package br.com.msantos.parking.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.msantos.parking.dtos.TabelaDePrecosDto;
import br.com.msantos.parking.forms.AtualizacaoTabelaDePrecosForm;
import br.com.msantos.parking.forms.TabelaDePrecosForm;
import br.com.msantos.parking.models.TabelaDePrecos;
import br.com.msantos.parking.repository.EstacionamentoRepository;
import br.com.msantos.parking.repository.TabelaDePrecosRepository;

@RestController
@RequestMapping("/admin/tabelaDePrecos")
public class TabelaDePrecosController {

	@Autowired
	private TabelaDePrecosRepository tabelaDePrecosRepository;

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;

	@GetMapping
	@Cacheable(value = "listaTabelaDePrecos")
	public Page<TabelaDePrecosDto> lista(@RequestParam(required = false) Long id,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (id == null) {
			Page<TabelaDePrecos> tabelaDePrecos = tabelaDePrecosRepository.findAll(paginacao);
			return TabelaDePrecosDto.converter(tabelaDePrecos);
		} else {
			Page<TabelaDePrecos> tabelaDePrecos = tabelaDePrecosRepository.findByEstacionamento_Id(id, paginacao);
			return TabelaDePrecosDto.converter(tabelaDePrecos);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<TabelaDePrecosDto> detalhe(@PathVariable Long id) {
		Optional<TabelaDePrecos> tabelaDePrecosOptional = tabelaDePrecosRepository.findById(id);

		if (tabelaDePrecosOptional.isPresent()) {
			return ResponseEntity.ok(new TabelaDePrecosDto(tabelaDePrecosOptional.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "listaTabelaDePrecos", allEntries = true)
	public ResponseEntity<TabelaDePrecosDto> cadastra(@RequestBody @Valid TabelaDePrecosForm form,
			UriComponentsBuilder uriBuilder) {

		TabelaDePrecos tabelaDePrecos = form.conterter(form, estacionamentoRepository);
		tabelaDePrecosRepository.save(tabelaDePrecos);

		URI uri = uriBuilder.path("/admin/tabelaDePrecos/{id}").buildAndExpand(tabelaDePrecos.getId()).toUri();

		return ResponseEntity.created(uri).body(new TabelaDePrecosDto(tabelaDePrecos));

	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaTabelaDePrecos", allEntries = true)
	public ResponseEntity<?> remove(@PathVariable Long id) {

		Optional<TabelaDePrecos> tabelaDePrecosOptional = tabelaDePrecosRepository.findById(id);

		if (tabelaDePrecosOptional.isPresent()) {
			tabelaDePrecosRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaTabelaDePrecos", allEntries = true)
	public ResponseEntity<TabelaDePrecosDto> atualiza(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoTabelaDePrecosForm form) {

		Optional<TabelaDePrecos> tabelaDePrecosOptional = tabelaDePrecosRepository.findById(id);

		if (tabelaDePrecosOptional.isPresent()) {
			TabelaDePrecos tabelaDePrecos = form.atualiza(id, tabelaDePrecosRepository);
			return ResponseEntity.ok(new TabelaDePrecosDto(tabelaDePrecos));
		}

		return ResponseEntity.notFound().build();
	}

}

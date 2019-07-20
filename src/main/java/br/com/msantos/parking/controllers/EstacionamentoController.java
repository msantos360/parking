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

import br.com.msantos.parking.dtos.EstacionamentoDto;
import br.com.msantos.parking.forms.AtualizacaoEstacionamentoForm;
import br.com.msantos.parking.forms.EstacionamentoForm;
import br.com.msantos.parking.models.Estacionamento;
import br.com.msantos.parking.repository.EstacionamentoRepository;

@RestController
@RequestMapping("/admin/estacionamento")
public class EstacionamentoController {

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;

	@GetMapping
	@Cacheable(value = "listaDeEstacionamentos")
	public Page<EstacionamentoDto> lista(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "nome", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (nome == null) {
			Page<Estacionamento> estacionamento = estacionamentoRepository.findAll(paginacao);
			return EstacionamentoDto.converter(estacionamento);
		} else {
			Page<Estacionamento> estacionamento = estacionamentoRepository.findByNome(nome, paginacao);
			return EstacionamentoDto.converter(estacionamento);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<EstacionamentoDto> detalhe(@PathVariable Long id) {
		Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(id);

		if (estacionamento.isPresent()) {
			return ResponseEntity.ok(new EstacionamentoDto(estacionamento.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeEstacionamentos", allEntries = true)
	public ResponseEntity<EstacionamentoDto> cadastra(@RequestBody @Valid EstacionamentoForm form,
			UriComponentsBuilder uriBuilder) {

		Estacionamento estacionamento = form.converter(form);
		estacionamentoRepository.save(estacionamento);

		URI uri = uriBuilder.path("/admin/estacionamento/{id}").buildAndExpand(estacionamento.getId()).toUri();

		return ResponseEntity.created(uri).body(new EstacionamentoDto(estacionamento));

	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeEstacionamentos", allEntries = true)
	public ResponseEntity<?> remove(@PathVariable Long id) {

		Optional<Estacionamento> estacionamentoOptional = estacionamentoRepository.findById(id);
		if (estacionamentoOptional.isPresent()) {
			estacionamentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeEstacionamentos", allEntries = true)
	public ResponseEntity<EstacionamentoDto> atualiza(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoEstacionamentoForm form) {

		Optional<Estacionamento> estacionamentoOptional = estacionamentoRepository.findById(id);
		if (estacionamentoOptional.isPresent()) {
			Estacionamento estacionamento = form.atualiza(id, estacionamentoRepository);
			return ResponseEntity.ok(new EstacionamentoDto(estacionamento));
		}

		return ResponseEntity.notFound().build();
	}

}

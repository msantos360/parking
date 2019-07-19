package br.com.msantos.parking.controllers;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.msantos.parking.dtos.TabelaDePrecosDto;
import br.com.msantos.parking.forms.TabelaDePrecosForm;
import br.com.msantos.parking.models.TabelaDePrecos;
import br.com.msantos.parking.repository.EstacionamentoRepository;
import br.com.msantos.parking.repository.TabelaDePrecosRepository;

@RestController
@RequestMapping("/tabelaDePrecos")
public class TabelaDePrecosController {

	@Autowired
	private TabelaDePrecosRepository tabelaDePrecosRepository;
	
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	@GetMapping
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
	
	@PostMapping
	@Transactional
	public ResponseEntity<TabelaDePrecosDto> cadastra(@RequestBody @Valid TabelaDePrecosForm form, UriComponentsBuilder uriBuilder) {

		TabelaDePrecos tabelaDePrecos = form.conterter(form, estacionamentoRepository);
		tabelaDePrecosRepository.save(tabelaDePrecos);

		URI uri = uriBuilder.path("/tabelaDePrecos/{id}").buildAndExpand(tabelaDePrecos.getId()).toUri();

		return ResponseEntity.created(uri).body(new TabelaDePrecosDto(tabelaDePrecos));

	}
	
	
	
	
	
	
	
	
	
	
}

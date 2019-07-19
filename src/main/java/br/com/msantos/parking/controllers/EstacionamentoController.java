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

import br.com.msantos.parking.dtos.EstacionamentoDto;
import br.com.msantos.parking.forms.EstacionamentoForm;
import br.com.msantos.parking.models.Estacionamento;
import br.com.msantos.parking.repository.EstacionamentoRepository;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	@GetMapping
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
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstacionamentoDto> cadastra(@RequestBody @Valid EstacionamentoForm form, UriComponentsBuilder uriBuilder) {

		Estacionamento estacionamento = form.converter(form);
		estacionamentoRepository.save(estacionamento);

		URI uri = uriBuilder.path("/estacionamento/{id}").buildAndExpand(estacionamento.getId()).toUri();

		return ResponseEntity.created(uri).body(new EstacionamentoDto(estacionamento));

	}
	
	
}

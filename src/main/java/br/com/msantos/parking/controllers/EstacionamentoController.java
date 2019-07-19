package br.com.msantos.parking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.msantos.parking.dtos.EstacionamentoDto;
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
	
	
}

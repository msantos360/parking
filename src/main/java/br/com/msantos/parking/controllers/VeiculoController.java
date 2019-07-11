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

import br.com.msantos.parking.dtos.VeiculoDto;
import br.com.msantos.parking.models.Veiculo;
import br.com.msantos.parking.repository.VeiculoRepository;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoR;
	
	@GetMapping
	public Page<VeiculoDto> lista(@RequestParam(required = false) String modelo,
			@PageableDefault(sort = "modelo", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){
		
		if (modelo == null) {
			Page<Veiculo> veiculo = veiculoR.findAll(paginacao);
			return VeiculoDto.converter(veiculo);
		} else {
			Page<Veiculo> veiculo = veiculoR.findByModelo(modelo, paginacao);
			return VeiculoDto.converter(veiculo);
		}
	}
}

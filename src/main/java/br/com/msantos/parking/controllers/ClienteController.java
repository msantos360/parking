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

import br.com.msantos.parking.dtos.ClienteDto;
import br.com.msantos.parking.models.Cliente;
import br.com.msantos.parking.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteR;

	@GetMapping
	public Page<ClienteDto> lista(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "nome", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if(nome == null) {
			Page<Cliente> cliente = clienteR.findAll(paginacao);
			return ClienteDto.converter(cliente);
		} else {
			Page<Cliente> cliente = clienteR.findByNome(nome, paginacao);	
			return ClienteDto.converter(cliente);
		}
		
	}
}

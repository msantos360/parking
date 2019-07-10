package br.com.msantos.parking.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.msantos.parking.dtos.ClienteDto;
import br.com.msantos.parking.forms.ClienteForm;
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
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> cadastra(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
		
		Cliente cliente = form.converter(form);		
		clienteR.save(cliente);
		
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> detalhe(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteR.findById(id);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(cliente.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id){
		
		Optional<Cliente> cliente = clienteR.findById(id);
		if (cliente.isPresent()) {
			clienteR.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

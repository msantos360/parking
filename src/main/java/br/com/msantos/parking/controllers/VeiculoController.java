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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.msantos.parking.dtos.VeiculoDto;
import br.com.msantos.parking.forms.AtualizacaoVeiculoForm;
import br.com.msantos.parking.forms.VeiculoForm;
import br.com.msantos.parking.models.Veiculo;
import br.com.msantos.parking.repository.ClienteRepository;
import br.com.msantos.parking.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public Page<VeiculoDto> lista(@RequestParam(required = false) String modelo,
			@PageableDefault(sort = "modelo", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (modelo == null) {
			Page<Veiculo> veiculo = veiculoRepository.findAll(paginacao);
			return VeiculoDto.converter(veiculo);
		} else {
			Page<Veiculo> veiculo = veiculoRepository.findByModelo(modelo, paginacao);
			return VeiculoDto.converter(veiculo);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<VeiculoDto> detalhe(@PathVariable Long id) {
		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

		if (veiculoOptional.isPresent()) {
			return ResponseEntity.ok(new VeiculoDto(veiculoOptional.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {

		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

		if (veiculoOptional.isPresent()) {
			veiculoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping
	@Transactional
	public ResponseEntity<VeiculoDto> cadastra(@RequestBody @Valid VeiculoForm form, UriComponentsBuilder uriBuilder) {

		Veiculo veiculo = form.conterter(form, clienteRepository);
		veiculoRepository.save(veiculo);

		URI uri = uriBuilder.path("/veiculo/{id}").buildAndExpand(veiculo.getId()).toUri();

		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));

	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VeiculoDto> atualiza(@PathVariable Long id, @RequestBody @Valid AtualizacaoVeiculoForm form){
		
		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
		
		if(veiculoOptional.isPresent()) {
			Veiculo veiculo = form.atualiza(id, veiculoRepository, clienteRepository);
			return ResponseEntity.ok(new VeiculoDto(veiculo));
		}
		
		return ResponseEntity.notFound().build();
	}

}

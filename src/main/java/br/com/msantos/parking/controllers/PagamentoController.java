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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.msantos.parking.dtos.PagamentoDto;
import br.com.msantos.parking.forms.PagamentoForm;
import br.com.msantos.parking.models.Pagamento;
import br.com.msantos.parking.models.StatusDePagamento;
import br.com.msantos.parking.repository.PagamentoRepository;

@RestController
@RequestMapping("/admin/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@GetMapping
	public Page<PagamentoDto> lista(@RequestParam(required = false) StatusDePagamento status,
			@PageableDefault(sort = "status", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (status == null) {
			Page<Pagamento> pagamento = pagamentoRepository.findAll(paginacao);
			return PagamentoDto.converter(pagamento);
		} else {
			Page<Pagamento> pagamento = pagamentoRepository.findByStatus(status, paginacao);
			return PagamentoDto.converter(pagamento);
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PagamentoDto> detalhe(@PathVariable Long id) {
		Optional<Pagamento> pagamentoOptional = pagamentoRepository.findById(id);

		if (pagamentoOptional.isPresent()) {
			return ResponseEntity.ok(new PagamentoDto(pagamentoOptional.get()));
		}

		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PagamentoDto> cadastra(@RequestBody @Valid PagamentoForm form, UriComponentsBuilder uriBuilder) {

		Pagamento pagamento = form.converter(form);
		pagamentoRepository.save(pagamento);

		URI uri = uriBuilder.path("/admin/pagamento/{id}").buildAndExpand(pagamento.getId()).toUri();

		return ResponseEntity.created(uri).body(new PagamentoDto(pagamento));

	}
	
}

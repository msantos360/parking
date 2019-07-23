package br.com.msantos.parking.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.msantos.parking.dtos.MovimentacoesCadastroDto;
import br.com.msantos.parking.dtos.MovimentacoesDto;
import br.com.msantos.parking.forms.AtualizacaoMovimentacoesForm;
import br.com.msantos.parking.forms.MovimentacoesForm;
import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.Pagamento;
import br.com.msantos.parking.models.tabelaDePrecos.RealizaPagamento;
import br.com.msantos.parking.repository.ClienteRepository;
import br.com.msantos.parking.repository.MovimentacoesRepository;
import br.com.msantos.parking.repository.PagamentoRepository;
import br.com.msantos.parking.repository.VeiculoRepository;

@RestController
@RequestMapping("/admin/movimentacoes")
public class MovimentacoesController {

	@Autowired
	private MovimentacoesRepository movimentacoesRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@GetMapping("/{id}")
	public ResponseEntity<MovimentacoesDto> detalhe(@PathVariable Long id) {
		Optional<Movimentacoes> movimentacoesOptional = movimentacoesRepository.findById(id);

		if (movimentacoesOptional.isPresent()) {
			return ResponseEntity.ok(new MovimentacoesDto(movimentacoesOptional.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<MovimentacoesCadastroDto> cadastraEntradaVeiculo(@RequestBody @Valid MovimentacoesForm form,
			UriComponentsBuilder uriBuilder) {

		Movimentacoes movimentacoes = form.conterter(form, clienteRepository, veiculoRepository);

		movimentacoesRepository.save(movimentacoes);

		URI uri = uriBuilder.path("/admin/movimentacoes/{id}").buildAndExpand(movimentacoes.getId()).toUri();

		return ResponseEntity.created(uri).body(new MovimentacoesCadastroDto(movimentacoes));

	}

	@PutMapping("/finaliza/{id}")
	@Transactional
	public ResponseEntity<MovimentacoesDto> cadastraSaidaVeiculo(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoMovimentacoesForm form) {

		Optional<Movimentacoes> movimentacaoOptional = movimentacoesRepository.findById(id);

		if (movimentacaoOptional.isPresent()) {

			Pagamento pagamento = new RealizaPagamento().pagar(movimentacaoOptional.get(), veiculoRepository);
			pagamentoRepository.save(pagamento);

			Movimentacoes movimentacoes = form.atualiza(id, movimentacoesRepository, pagamento);
			return ResponseEntity.ok(new MovimentacoesDto(movimentacoes));
		}

		return ResponseEntity.notFound().build();

	}

}

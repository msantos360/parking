package br.com.msantos.parking.forms;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.FormasDePagamento;
import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.StatusDePagamento;
import br.com.msantos.parking.repository.MovimentacoesRepository;

public class AtualizacaoMovimentacoesForm {

	@NotNull
	private FormasDePagamento formaDePagamento;

	public void setFormaDePagamento(FormasDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public Movimentacoes atualiza(Long id, MovimentacoesRepository movimentacoesRepository, BigDecimal totalApagar) {

		Movimentacoes movimentacao = movimentacoesRepository.getOne(id);

		movimentacao.setStatusDePagamento(StatusDePagamento.PAGO);
		movimentacao.setFormaDePagamento(formaDePagamento);
		movimentacao.setHorarioSaida(Calendar.getInstance());
		movimentacao.setTotalApagar(totalApagar);

		return movimentacao;
	}

}

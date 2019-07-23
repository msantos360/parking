package br.com.msantos.parking.forms;

import java.util.Calendar;

import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.Pagamento;
import br.com.msantos.parking.repository.MovimentacoesRepository;

public class AtualizacaoMovimentacoesForm {

	private Calendar horarioSaida;
	
	public void setHorarioSaida(Calendar horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public Movimentacoes atualiza(Long id, MovimentacoesRepository movimentacoesRepository, Pagamento pagamento) {

		Movimentacoes movimentacao = movimentacoesRepository.getOne(id);

		movimentacao.setHorarioSaida(horarioSaida);
		movimentacao.setPagamento(pagamento);

		return movimentacao;
	}

}

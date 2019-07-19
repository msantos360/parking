package br.com.msantos.parking.forms;

import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.Estacionamento;
import br.com.msantos.parking.repository.EstacionamentoRepository;

public class AtualizacaoEstacionamentoForm {

	@NotNull
	private Integer capacidadeVagas;

	public void setCapacidadeVagas(Integer capacidadeVagas) {
		this.capacidadeVagas = capacidadeVagas;
	}

	public Estacionamento atualiza(Long id, EstacionamentoRepository estacionamentoRepository) {
		Estacionamento estacionamento = estacionamentoRepository.getOne(id);
		estacionamento.setCapacidadeVagas(capacidadeVagas);
		
		return estacionamento;
	}
}

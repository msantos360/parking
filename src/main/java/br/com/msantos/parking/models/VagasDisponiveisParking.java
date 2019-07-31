package br.com.msantos.parking.models;

import java.util.List;

import br.com.msantos.parking.repository.EstacionamentoRepository;
import br.com.msantos.parking.repository.MovimentacoesRepository;

public class VagasDisponiveisParking {

	public Boolean autorizaEntrada(Long idEstacionamento, MovimentacoesRepository movimentacoesRepository,
			EstacionamentoRepository estacionamentoRepository) {

		Estacionamento estacionamentoId = estacionamentoRepository.findById(idEstacionamento).get();

		List<Movimentacoes> vagasOcupadas = movimentacoesRepository.vagasOcupadasPorEstacionamento(estacionamentoId);

		Integer vagasDisponiveis = (estacionamentoId.getCapacidadeVagas() - vagasOcupadas.size());
		
		if(!vagasDisponiveis.equals(0)) {
			return true;
		}
		
		return false;
	}
}

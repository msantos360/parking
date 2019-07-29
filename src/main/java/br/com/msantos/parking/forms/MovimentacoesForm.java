package br.com.msantos.parking.forms;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.Cliente;
import br.com.msantos.parking.models.Estacionamento;
import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.Veiculo;
import br.com.msantos.parking.repository.ClienteRepository;
import br.com.msantos.parking.repository.EstacionamentoRepository;
import br.com.msantos.parking.repository.VeiculoRepository;

public class MovimentacoesForm {

	@NotNull
	private String placa;
	
	@NotNull
	private Long estacionamentoId;

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setEstacionamentoId(Long estacionamentoId) {
		this.estacionamentoId = estacionamentoId;
	}

	public Movimentacoes conterter(MovimentacoesForm form, ClienteRepository clienteRepository,
			VeiculoRepository veiculoRepository, EstacionamentoRepository estacionamentoRepository) {

		Veiculo achaVeiculoPorPorPlaca = veiculoRepository.findByPlaca(placa);
		Optional<Cliente> achaClientePorId = clienteRepository.findById(achaVeiculoPorPorPlaca.getCliente().getId());
		Optional<Estacionamento> achaEstacionamentoPorId = estacionamentoRepository.findById(estacionamentoId);
		
		return new Movimentacoes(achaClientePorId.get(), achaVeiculoPorPorPlaca, achaEstacionamentoPorId.get());

	}

}

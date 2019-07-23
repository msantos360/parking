package br.com.msantos.parking.forms;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.Cliente;
import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.Veiculo;
import br.com.msantos.parking.repository.ClienteRepository;
import br.com.msantos.parking.repository.VeiculoRepository;

public class MovimentacoesForm {

	@NotNull
	private String placa;

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Movimentacoes conterter(MovimentacoesForm form, ClienteRepository clienteRepository,
			VeiculoRepository veiculoRepository) {

		Veiculo achaVeiculoPorPorPlaca = veiculoRepository.findByPlaca(placa);
		Optional<Cliente> achaClientePorId = clienteRepository.findById(achaVeiculoPorPorPlaca.getCliente().getId());
		
		return new Movimentacoes(achaClientePorId.get(), achaVeiculoPorPorPlaca);

	}

}

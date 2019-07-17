package br.com.msantos.parking.forms;

import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.Cliente;
import br.com.msantos.parking.models.TipoVeiculo;
import br.com.msantos.parking.models.Veiculo;
import br.com.msantos.parking.repository.ClienteRepository;
import br.com.msantos.parking.repository.VeiculoRepository;

public class AtualizacaoVeiculoForm {

	@NotNull
	private TipoVeiculo tipo;

	@NotNull
	private Long clienteId;

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Veiculo atualiza(Long id, VeiculoRepository veiculoRepository, ClienteRepository clienteRepository) {
		Veiculo veiculo = veiculoRepository.getOne(id);
		Cliente cliente = clienteRepository.getOne(this.clienteId);

		veiculo.setTipo(tipo);
		veiculo.setCliente(cliente);

		return veiculo;
	}

}

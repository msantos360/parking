package br.com.msantos.parking.forms;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.Cliente;
import br.com.msantos.parking.models.TipoVeiculo;
import br.com.msantos.parking.models.Veiculo;
import br.com.msantos.parking.repository.ClienteRepository;

public class VeiculoForm {

	@NotNull
	@NotEmpty
	private String modelo;

	@NotNull
	@NotEmpty
	private String marca;

	@NotNull
	@NotEmpty
	private String placa;

	@NotNull
	private TipoVeiculo tipo;

	@NotNull
	private Long clienteId;

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Veiculo conterter(VeiculoForm form, ClienteRepository cr) {
		
		Optional<Cliente> achaClientePorId = cr.findById(clienteId);
		
		return new Veiculo(modelo, marca, placa, tipo, achaClientePorId.get());
	}
	
	
}

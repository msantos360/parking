package br.com.msantos.parking.dtos;

import org.springframework.data.domain.Page;

import br.com.msantos.parking.models.TipoVeiculo;
import br.com.msantos.parking.models.Veiculo;

public class VeiculoDto {

	private Long id;

	private String modelo;

	private String marca;

	private String placa;

	private TipoVeiculo tipo;

	private Long clienteId;

	public VeiculoDto(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.modelo = veiculo.getModelo();
		this.marca = veiculo.getMarca();
		this.placa = veiculo.getPlaca();
		this.tipo = veiculo.getTipo();
		this.clienteId = veiculo.getCliente().getId();
	}

	public Long getClienteId() {
		return clienteId;
	}

	public Long getId() {
		return id;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getPlaca() {
		return placa;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public static Page<VeiculoDto> converter(Page<Veiculo> veiculo) {
		return veiculo.map(VeiculoDto::new);
	}

}

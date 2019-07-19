package br.com.msantos.parking.dtos;

import org.springframework.data.domain.Page;

import br.com.msantos.parking.models.Estacionamento;

public class EstacionamentoDto {

	private Long id;

	private Integer capacidadeVagas;

	private String nome;

	private Long cnpj;

	public EstacionamentoDto(Estacionamento estacionamento) {
		this.id = estacionamento.getId();
		this.capacidadeVagas = estacionamento.getCapacidadeVagas();
		this.nome = estacionamento.getNome();
		this.cnpj = estacionamento.getCnpj();
	}

	public Long getId() {
		return id;
	}

	public Integer getCapacidadeVagas() {
		return capacidadeVagas;
	}

	public String getNome() {
		return nome;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public static Page<EstacionamentoDto> converter(Page<Estacionamento> estacionamento) {
		return estacionamento.map(EstacionamentoDto::new);
	}

}

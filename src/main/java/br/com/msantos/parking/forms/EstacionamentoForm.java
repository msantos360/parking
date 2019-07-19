package br.com.msantos.parking.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.Estacionamento;
import br.com.msantos.parking.validation.CnpjValidation;

public class EstacionamentoForm {

	@NotNull
	private Integer capacidadeVagas;

	@NotNull
	@NotEmpty
	private String nome;
	
	@NotNull
	private Long cnpj;

	public Integer getCapacidadeVagas() {
		return capacidadeVagas;
	}

	public void setCapacidadeVagas(Integer capacidadeVagas) {
		this.capacidadeVagas = capacidadeVagas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		
		if(CnpjValidation.validaCnpj(cnpj.toString())) {
			
			this.cnpj = cnpj;
			
		}
		
		return;
	}

	public Estacionamento converter(EstacionamentoForm form) {
		return new Estacionamento(nome, capacidadeVagas, cnpj);
	}
	
	
}

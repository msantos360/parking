package br.com.msantos.parking.forms;

import java.util.Calendar;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.Cliente;
import br.com.msantos.parking.models.TipoCliente;
import br.com.msantos.parking.validation.CpfValidation;

public class ClienteForm {

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	@AssertTrue
	private Long cpf;

	@NotNull
	private Calendar dataNascimento;

	@NotNull
	private TipoCliente tipo;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(Long cpf) {
	
		if(CpfValidation.validaCpf(cpf.toString())) {
			
			this.cpf = cpf;
		}
		
		return;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public Cliente converter(ClienteForm form) {

		return new Cliente(nome, cpf, dataNascimento, tipo);
	}
	
	

}

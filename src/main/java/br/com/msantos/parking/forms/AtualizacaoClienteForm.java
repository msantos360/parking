package br.com.msantos.parking.forms;

import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.Cliente;
import br.com.msantos.parking.models.TipoCliente;
import br.com.msantos.parking.repository.ClienteRepository;

public class AtualizacaoClienteForm {

	@NotNull
	private String nome;
	
	@NotNull
	private TipoCliente tipo;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
	
	public Cliente atualiza(Long id, ClienteRepository clienteR) {
		Cliente cliente = clienteR.getOne(id);
		
		cliente.setNome(nome);
		cliente.setTipo(tipo);
		
		return cliente;
	}
}

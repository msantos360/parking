package br.com.msantos.parking.dtos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.data.domain.Page;

import br.com.msantos.parking.models.Cliente;
import br.com.msantos.parking.models.TipoCliente;

public class ClienteDto {

	private Long id;

	private String nome;
	
	private Long cpf;

	private Calendar dataNascimento;

	private TipoCliente tipo;
	
	private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.dataNascimento = cliente.getDataNascimento();
		this.tipo = cliente.getTipo();
		this.cpf = cliente.getCpf();
	}

	public Long getId() {
		return id;
	}
	
	public Long getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getDataNascimento() {
		return df.format(dataNascimento.getTime());
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public static Page<ClienteDto> converter(Page<Cliente> cliente) {
		return cliente.map(ClienteDto::new);
	}

}

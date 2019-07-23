package br.com.msantos.parking.dtos;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.msantos.parking.models.FormasDePagamento;
import br.com.msantos.parking.models.StatusDePagamento;

public class MovimentacoesSaidaDto {

	private Long id;

	private Calendar horarioEntrada = Calendar.getInstance();

	private Calendar horarioSaida;

	private BigDecimal totalApagar;

	private StatusDePagamento statusDePagamento;

	private FormasDePagamento formaDePagamento;

	private Long veiculo;

	private Long cliente;
	
	private DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

	public Long getId() {
		return id;
	}

	public String getHorarioEntrada() {
		return df.format(horarioEntrada.getTime());
	}

	public String getHorarioSaida() {
		return df.format(horarioSaida.getTime());
	}

	public BigDecimal getTotalApagar() {
		return totalApagar;
	}

	public StatusDePagamento getStatusDePagamento() {
		return statusDePagamento;
	}

	public FormasDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public Long getVeiculo() {
		return veiculo;
	}

	public Long getCliente() {
		return cliente;
	}

}

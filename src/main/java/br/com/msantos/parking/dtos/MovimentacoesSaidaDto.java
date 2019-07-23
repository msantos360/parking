package br.com.msantos.parking.dtos;

import java.math.BigDecimal;
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

	public Long getId() {
		return id;
	}

	public Calendar getHorarioEntrada() {
		return horarioEntrada;
	}

	public Calendar getHorarioSaida() {
		return horarioSaida;
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

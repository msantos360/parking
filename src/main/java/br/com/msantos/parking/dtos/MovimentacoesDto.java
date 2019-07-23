package br.com.msantos.parking.dtos;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.data.domain.Page;

import br.com.msantos.parking.models.FormasDePagamento;
import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.StatusDePagamento;

public class MovimentacoesDto {

	private Long id;

	private Calendar horarioEntrada;

	private Calendar horarioSaida;

	private BigDecimal totalApagar;

	private StatusDePagamento statusDePagamento;

	private FormasDePagamento formaDePagamento;

	private Long veiculo;

	private Long cliente;

	public MovimentacoesDto(Movimentacoes movimentacoes) {
		this.id = movimentacoes.getId();
		this.horarioEntrada = movimentacoes.getHorarioEntrada();
		this.horarioSaida = movimentacoes.getHorarioSaida();
		this.totalApagar = movimentacoes.getTotalApagar();
		this.statusDePagamento = movimentacoes.getStatusDePagamento();
		this.formaDePagamento = movimentacoes.getFormaDePagamento();
		this.veiculo = movimentacoes.getVeiculo().getId();
		this.cliente = movimentacoes.getCliente().getId();
	}

	public Long getId() {
		return id;
	}

	public Calendar getHorarioEntrada() {
		return horarioEntrada;
	}

	public Calendar getHorarioSaida() {
		return horarioSaida;
	}

	public Long getVeiculo() {
		return veiculo;
	}

	public Long getCliente() {
		return cliente;
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

	public static Page<MovimentacoesDto> converter(Page<Movimentacoes> movimentacoes) {
		return movimentacoes.map(MovimentacoesDto::new);
	}

}

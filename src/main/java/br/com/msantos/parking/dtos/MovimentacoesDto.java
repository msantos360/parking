package br.com.msantos.parking.dtos;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	
	private Long estacionamento;
	
	private DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

	public MovimentacoesDto(Movimentacoes movimentacoes) {
		this.id = movimentacoes.getId();
		this.horarioEntrada = movimentacoes.getHorarioEntrada();
		this.horarioSaida = movimentacoes.getHorarioSaida();
		this.totalApagar = movimentacoes.getTotalApagar();
		this.statusDePagamento = movimentacoes.getStatusDePagamento();
		this.formaDePagamento = movimentacoes.getFormaDePagamento();
		this.veiculo = movimentacoes.getVeiculo().getId();
		this.cliente = movimentacoes.getCliente().getId();
		this.estacionamento = movimentacoes.getEstacionamento().getId();
	}

	public Long getId() {
		return id;
	}

	public String getHorarioEntrada() {
		return df.format(horarioEntrada.getTime());
	}

	public String getHorarioSaida() {
		return df.format(horarioSaida.getTime());
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
	
	public Long getEstacionamento() {
		return estacionamento;
	}

	public static Page<MovimentacoesDto> converter(Page<Movimentacoes> movimentacoes) {
		return movimentacoes.map(MovimentacoesDto::new);
	}

}

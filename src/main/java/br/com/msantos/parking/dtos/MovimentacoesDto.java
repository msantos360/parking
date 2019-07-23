package br.com.msantos.parking.dtos;

import java.util.Calendar;

import org.springframework.data.domain.Page;

import br.com.msantos.parking.models.Movimentacoes;

public class MovimentacoesDto {

	private Long id;

	private Calendar horarioEntrada;

	private Calendar horarioSaida;

	private Long veiculo;

	private Long cliente;

	public MovimentacoesDto(Movimentacoes movimentacoes) {
		this.id = movimentacoes.getId();
		this.horarioEntrada = movimentacoes.getHorarioEntrada();
		this.horarioSaida = movimentacoes.getHorarioSaida();
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

	public static Page<MovimentacoesDto> converter(Page<Movimentacoes> movimentacoes) {
		return movimentacoes.map(MovimentacoesDto::new);
	}

}

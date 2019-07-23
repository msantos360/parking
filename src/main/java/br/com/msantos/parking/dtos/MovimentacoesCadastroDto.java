package br.com.msantos.parking.dtos;

import java.util.Calendar;

import org.springframework.data.domain.Page;

import br.com.msantos.parking.models.Movimentacoes;

public class MovimentacoesCadastroDto {

	private Long id;

	private Calendar horarioEntrada;

	private Long veiculo;

	private Long cliente;

	public MovimentacoesCadastroDto(Movimentacoes movimentacoes) {
		this.id = movimentacoes.getId();
		this.horarioEntrada = movimentacoes.getHorarioEntrada();
		this.veiculo = movimentacoes.getVeiculo().getId();
		this.cliente = movimentacoes.getCliente().getId();
	}

	public Long getId() {
		return id;
	}

	public Calendar getHorarioEntrada() {
		return horarioEntrada;
	}

	public Long getVeiculo() {
		return veiculo;
	}

	public Long getCliente() {
		return cliente;
	}

	public static Page<MovimentacoesCadastroDto> converter(Page<Movimentacoes> movimentacoes) {
		return movimentacoes.map(MovimentacoesCadastroDto::new);
	}

}

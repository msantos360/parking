package br.com.msantos.parking.dtos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.data.domain.Page;

import br.com.msantos.parking.models.Movimentacoes;

public class MovimentacoesCadastroDto {

	private Long id;

	private Calendar horarioEntrada;

	private Long veiculo;

	private Long cliente;
	
	private DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

	public MovimentacoesCadastroDto(Movimentacoes movimentacoes) {
		this.id = movimentacoes.getId();
		this.horarioEntrada = movimentacoes.getHorarioEntrada();
		this.veiculo = movimentacoes.getVeiculo().getId();
		this.cliente = movimentacoes.getCliente().getId();
	}

	public Long getId() {
		return id;
	}

	public String getHorarioEntrada() {
		return df.format(horarioEntrada.getTime());
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

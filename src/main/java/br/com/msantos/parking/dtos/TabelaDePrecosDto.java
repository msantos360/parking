package br.com.msantos.parking.dtos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.data.domain.Page;

import br.com.msantos.parking.models.TabelaDePrecos;
import br.com.msantos.parking.models.TipoVeiculo;

public class TabelaDePrecosDto {

	private Long id;

	private TipoVeiculo tipo;

	private BigDecimal precoDaPrimeiraHora;

	private BigDecimal precoDasDemaisHoras;

	private BigDecimal precoDaDiaria;

	private BigDecimal precoMensalidade;

	private Long estacionamentoId;
	
	public TabelaDePrecosDto(TabelaDePrecos tabelaDePrecos) {
		this.id = tabelaDePrecos.getId();
		this.tipo = tabelaDePrecos.getTipo();
		this.precoDaPrimeiraHora = tabelaDePrecos.getPrecoDaPrimeiraHora();
		this.precoDasDemaisHoras = tabelaDePrecos.getPrecoDasDemaisHoras();
		this.precoDaDiaria = tabelaDePrecos.getPrecoDaDiaria();
		this.precoMensalidade = tabelaDePrecos.getPrecoMensalidade();
		this.estacionamentoId = tabelaDePrecos.getEstacionamento().getId();
	}

	public Long getId() {
		return id;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public BigDecimal getPrecoDaPrimeiraHora() {
		return precoDaPrimeiraHora.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getPrecoDasDemaisHoras() {
		return precoDasDemaisHoras.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getPrecoDaDiaria() {
		return precoDaDiaria.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getPrecoMensalidade() {
		return precoMensalidade.setScale(2, RoundingMode.HALF_UP);
	}

	public Long getEstacionamentoId() {
		return estacionamentoId;
	}

	public static Page<TabelaDePrecosDto> converter(Page<TabelaDePrecos> tabelaDePrecos) {
		return tabelaDePrecos.map(TabelaDePrecosDto::new);
	}
	
	
}

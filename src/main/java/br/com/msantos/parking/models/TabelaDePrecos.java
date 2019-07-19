package br.com.msantos.parking.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TabelaDePrecos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoVeiculo tipo;

	@Column(nullable = false)
	private BigDecimal precoDaPrimeiraHora;

	@Column(nullable = false)
	private BigDecimal precoDasDemaisHoras;

	private BigDecimal precoDaDiaria;

	private BigDecimal precoMensalidade;

	@ManyToOne
	private Estacionamento estacionamento;

	/** Hibernate only **/
	@Deprecated
	public TabelaDePrecos() {

	}

	public TabelaDePrecos(TipoVeiculo tipo, BigDecimal precoDaPrimeiraHora, BigDecimal precoDasDemaisHoras,
			BigDecimal precoDaDiaria, BigDecimal precoMensalidade, Estacionamento estacionamento) {
		this.tipo = tipo;
		this.precoDaPrimeiraHora = precoDaPrimeiraHora;
		this.precoDasDemaisHoras = precoDasDemaisHoras;
		this.precoDaDiaria = precoDaDiaria;
		this.precoMensalidade = precoMensalidade;
		this.estacionamento = estacionamento;
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

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

	public void setPrecoDaPrimeiraHora(BigDecimal precoDaPrimeiraHora) {
		this.precoDaPrimeiraHora = precoDaPrimeiraHora;
	}

	public void setPrecoDasDemaisHoras(BigDecimal precoDasDemaisHoras) {
		this.precoDasDemaisHoras = precoDasDemaisHoras;
	}

	public void setPrecoDaDiaria(BigDecimal precoDaDiaria) {
		this.precoDaDiaria = precoDaDiaria;
	}

	public void setPrecoMensalidade(BigDecimal precoMensalidade) {
		this.precoMensalidade = precoMensalidade;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}
}

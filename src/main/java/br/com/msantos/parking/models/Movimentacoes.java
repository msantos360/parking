package br.com.msantos.parking.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movimentacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Calendar horarioEntrada = Calendar.getInstance();

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar horarioSaida;

	private BigDecimal totalApagar;
	
	@Enumerated(EnumType.STRING)
	private StatusDePagamento statusDePagamento = StatusDePagamento.PENDENTE;
	
	@Enumerated(EnumType.STRING)
	private FormasDePagamento formaDePagamento;

	@ManyToOne
	private Veiculo veiculo;

	@ManyToOne
	private Cliente cliente;

	/** Hibernate only **/
	@Deprecated
	public Movimentacoes() {

	}

	public Movimentacoes(Cliente cliente, Veiculo veiculo) {
		this.cliente = cliente;
		this.veiculo = veiculo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setHorarioEntrada(Calendar horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public void setHorarioSaida(Calendar horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public void setTotalApagar(BigDecimal totalApagar) {
		this.totalApagar = totalApagar;
	}

	public void setStatusDePagamento(StatusDePagamento statusDePagamento) {
		this.statusDePagamento = statusDePagamento;
	}

	public void setFormaDePagamento(FormasDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public BigDecimal getTotalApagar() {
		return totalApagar.setScale(2, RoundingMode.HALF_UP);
	}

	public StatusDePagamento getStatusDePagamento() {
		return statusDePagamento;
	}

	public FormasDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	


}

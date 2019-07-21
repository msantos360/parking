package br.com.msantos.parking.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(nullable = false)
	private Calendar horarioSaida;

	@ManyToOne
	private Veiculo veiculo;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Pagamento pagamento;

	/** Hibernate only **/
	@Deprecated
	public Movimentacoes() {

	}

	public Movimentacoes(Calendar horarioSaida, Cliente cliente, Veiculo veiculo) {
		this.horarioSaida = horarioSaida;
		this.cliente = cliente;
		this.veiculo = veiculo;
	}

	public Long getId() {
		return id;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Calendar getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(Calendar horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public Calendar getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(Calendar horarioSaida) {
		this.horarioSaida = horarioSaida;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}


}

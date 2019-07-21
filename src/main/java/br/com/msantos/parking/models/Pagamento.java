package br.com.msantos.parking.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private BigDecimal totaApagar;

	private BigDecimal totalPago;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private FormasDePagamento formaDePagamento;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusDePagamento status;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDoPagamento = Calendar.getInstance();

	@OneToMany(mappedBy = "pagamento")
	private List<Movimentacoes> movimentacoes;

	/** Hibernate only **/
	@Deprecated
	public Pagamento() {

	}

	public Pagamento(BigDecimal totaApagar, BigDecimal totalPago, FormasDePagamento formaDePagamento,
			StatusDePagamento status, Calendar dataDoPagamento) {
		this.totaApagar = totaApagar;
		this.totalPago = totalPago;
		this.formaDePagamento = formaDePagamento;
		this.status = status;
		this.dataDoPagamento = dataDoPagamento;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getTotaApagar() {
		return totaApagar.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getTotalPago() {
		return totalPago.setScale(2, RoundingMode.HALF_UP);
	}

	public FormasDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public StatusDePagamento getStatus() {
		return status;
	}

	public List<Movimentacoes> getMovimentacoes() {
		return movimentacoes;
	}

	public Calendar getDataDoPagamento() {
		return dataDoPagamento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTotaApagar(BigDecimal totaApagar) {
		this.totaApagar = totaApagar;
	}

	public void setTotalPago(BigDecimal totalPago) {
		this.totalPago = totalPago;
	}

	public void setFormaDePagamento(FormasDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public void setStatus(StatusDePagamento status) {
		this.status = status;
	}

	public void setMovimentacoes(List<Movimentacoes> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public void setDataDoPagamento(Calendar dataDoPagamento) {
		this.dataDoPagamento = dataDoPagamento;
	}

}

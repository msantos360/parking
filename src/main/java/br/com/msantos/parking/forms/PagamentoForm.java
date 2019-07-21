package br.com.msantos.parking.forms;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.FormasDePagamento;
import br.com.msantos.parking.models.Pagamento;
import br.com.msantos.parking.models.StatusDePagamento;

public class PagamentoForm {

	@NotNull
	private BigDecimal totaApagar;

	@NotNull
	private BigDecimal totalPago;

	@NotNull
	private FormasDePagamento formaDePagamento;

	@NotNull
	private StatusDePagamento status;

	@NotNull
	private Calendar dataDoPagamento;

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

	public void setDataDoPagamento(Calendar dataDoPagamento) {
		this.dataDoPagamento = dataDoPagamento;
	}

	public BigDecimal getTotaApagar() {
		return totaApagar;
	}

	public BigDecimal getTotalPago() {
		return totalPago;
	}

	public FormasDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public StatusDePagamento getStatus() {
		return status;
	}

	public Calendar getDataDoPagamento() {
		return dataDoPagamento;
	}

	public Pagamento converter(PagamentoForm form) {
		return new Pagamento(totaApagar, totalPago, formaDePagamento, status, dataDoPagamento);
	}

}

package br.com.msantos.parking.forms;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.FormasDePagamento;
import br.com.msantos.parking.models.Pagamento;
import br.com.msantos.parking.models.StatusDePagamento;

public class PagamentoForm {

	private BigDecimal totalApagar;

	private BigDecimal totalPago;

	private FormasDePagamento formaDePagamento;

	@NotNull
	private StatusDePagamento status;

	public void setTotalApagar(BigDecimal totalApagar) {
		this.totalApagar = totalApagar;
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

	public Pagamento converter(PagamentoForm form) {
		return new Pagamento(totalApagar, totalPago, formaDePagamento, status);
	}

}

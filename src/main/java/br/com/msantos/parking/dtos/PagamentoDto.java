package br.com.msantos.parking.dtos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import org.springframework.data.domain.Page;

import br.com.msantos.parking.models.FormasDePagamento;
import br.com.msantos.parking.models.Pagamento;
import br.com.msantos.parking.models.StatusDePagamento;

public class PagamentoDto {

	private Long id;

	private BigDecimal totalApagar;

	private BigDecimal totalPago;

	private FormasDePagamento formaDePagamento;

	private StatusDePagamento status;

	private Calendar dataDoPagamento;

	public PagamentoDto(Pagamento pagamento) {
		this.id = pagamento.getId();
		this.totalApagar = pagamento.getTotalApagar();
		this.totalPago = pagamento.getTotalPago();
		this.formaDePagamento = pagamento.getFormaDePagamento();
		this.status = pagamento.getStatus();
		this.dataDoPagamento = pagamento.getDataDoPagamento();
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getTotalApagar() {
		return totalApagar.setScale(2, RoundingMode.HALF_UP);
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

	public Calendar getDataDoPagamento() {
		return dataDoPagamento;
	}

	public static Page<PagamentoDto> converter(Page<Pagamento> pagamento) {
		return pagamento.map(PagamentoDto::new);
	}

}

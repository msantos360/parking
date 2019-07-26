package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.repository.TabelaDePrecosRepository;

public abstract class TemplateCalculadoraDePrecos {

	protected Double precoDaPrimeiraHora;

	protected Double precoDasDemaisHoras;

	protected Double precoDaDiaria;

	protected Double precoDaMensalidade;

	protected BigDecimal totalApagar;

	protected TabelaDePrecosRepository tabelaDePrecosRepository;

	protected Movimentacoes movimentacoes;

	public TemplateCalculadoraDePrecos(TabelaDePrecosRepository tabelaDePrecosRepository, Movimentacoes movimentacoes) {
		
		this.tabelaDePrecosRepository = tabelaDePrecosRepository;
		this.movimentacoes = movimentacoes;
	}

	public BigDecimal getTotalApagar() {
		return totalApagar.setScale(2, RoundingMode.HALF_UP);
	}

	protected BigDecimal calculaValorDaPermanencia(Permanencia permanencia) {

		/** tolerancia de 10 minutos = R$ ZERO **/
		if (permanencia.getPermanenciaEmMinutos() <= 1) {
			return totalApagar = BigDecimal.ZERO;
		}

		/** valor da primeira hora R$ **/
		if (permanencia.getPermanenciaEmMinutos() <= 60) {
			return totalApagar = BigDecimal.valueOf(precoDaPrimeiraHora);

		}
		/** valor da primeira hora + as demais horas R$ **/
		if (permanencia.getPermanenciaEmMinutos() < 1440) {
			return totalApagar = BigDecimal
					.valueOf((permanencia.getPermanenciaEmMinutos() - 60) * (precoDasDemaisHoras / 60)
							+ precoDaPrimeiraHora);
		}

		/** valor da diaria R$ **/
		else {

			return totalApagar = BigDecimal.valueOf(permanencia.getPermanenciaEmDias() * precoDaDiaria);
		}
	}

}

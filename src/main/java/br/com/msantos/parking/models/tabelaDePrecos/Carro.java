package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;

public class Carro implements Precos {

	private static BigDecimal precoDaPrimeiraHora = BigDecimal.TEN;
	
	private static Long precoDaDiaria = (long) 9;
	
	private static Long precoDasDemaisHoras = (long) 2;

	@Override
	public BigDecimal calculaValorDaPermanencia(Permanencia permanencia) {

		if (permanencia.calculaPermanenciaEmDias() >= 1) {
			Long permanenciaEmDias = permanencia.calculaPermanenciaEmDias();
			return BigDecimal.valueOf(permanenciaEmDias * precoDaDiaria);
		}

		if (permanencia.calculaPermanenciaEmMinutos() <= 60) {
			return precoDaPrimeiraHora;

		} else {
			Long permanenciaEmHoras = permanencia.calculaPermanenciaEmHoras();
			BigDecimal totalApagar = BigDecimal.valueOf(permanenciaEmHoras * precoDasDemaisHoras);

			return totalApagar.add(precoDaPrimeiraHora);
		}
	}

}

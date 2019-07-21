package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Carro implements Precos {

	private static Double precoDaPrimeiraHora = 5.0;

	private static Double precoDaDiaria = 9.0;

	private static Double precoDasDemaisHoras = 2.0;

	private BigDecimal totalApagar;

	public BigDecimal getTotalApagar() {
		return totalApagar.setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal calculaValorDaPermanencia(Permanencia permanencia) {

		/** valor da primeira hora R$ **/
		if (permanencia.calculaPermanenciaEmMinutos() <= 60) {
			return totalApagar = BigDecimal
					.valueOf(permanencia.calculaPermanenciaEmMinutos() * (precoDaPrimeiraHora / 60));

		}
		/** valor da segunda hora + a primeira hora R$ **/
		if (permanencia.calculaPermanenciaEmMinutos() < 1440) {
			return totalApagar = BigDecimal
					.valueOf((permanencia.calculaPermanenciaEmMinutos() - 60) * (precoDasDemaisHoras / 60)
							+ precoDaPrimeiraHora);
		}

		/** valor da diaria R$ **/
		else {

			return totalApagar = BigDecimal.valueOf(permanencia.calculaPermanenciaEmDias() * precoDaDiaria);
		}
	}
}

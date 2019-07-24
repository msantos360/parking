package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadorDePrecos {

	public BigDecimal realizaCalculo(Permanencia permanencia, Precos precos) {
		
		BigDecimal totalApagar = precos.calculaValorDaPermanencia(permanencia);

		return totalApagar.setScale(2, RoundingMode.HALF_UP);
	}

}

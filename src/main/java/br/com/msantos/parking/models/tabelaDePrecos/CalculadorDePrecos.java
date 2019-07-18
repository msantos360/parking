package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadorDePrecos {

	private BigDecimal totalApagar;

	public BigDecimal getTotalApagar() {
		return totalApagar.setScale(2, RoundingMode.HALF_UP);
	}

	public void realizaCalculo(Permanencia permanencia, Precos precos) {

		this.totalApagar = precos.calculaValorDaPermanencia(permanencia);

	}

}

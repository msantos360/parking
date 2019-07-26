package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;

public class CalculadorDePrecos {

	public BigDecimal realizaCalculo(Precos precos) {
		
		return precos.getPrecosPorVeiculo();

	}

}

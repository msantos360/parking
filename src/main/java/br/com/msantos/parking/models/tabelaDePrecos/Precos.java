package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;

public interface Precos {

	BigDecimal calculaValorDaPermanencia(Permanencia permanencia);
}

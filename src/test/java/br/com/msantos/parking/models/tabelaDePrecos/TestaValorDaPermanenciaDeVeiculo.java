package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaValorDaPermanenciaDeVeiculo {

	private Permanencia permanencia;

	private Calendar entradaDoVeiculoNoEstacionamento;

	@Test
	public void testaValorDaPermaneciaDoCarroPorAte60minutos() {

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento);
		Precos precoDaPermanencia = new Carro();
		CalculadorDePrecos calculador = new CalculadorDePrecos();

		calculador.realizaCalculo(permanencia, precoDaPermanencia);

		BigDecimal precoEsperado = new BigDecimal("5.00");

		Assert.assertEquals(precoEsperado, calculador.getTotalApagar());

	}

	@Test
	public void testaValorDaPermaneciaDoCarroAcimaDe60minutosMaisOAcrecimoDoValorDaPrimeiraHora() {

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento);
		Precos precoDaPermanencia = new Carro();
		CalculadorDePrecos calculador = new CalculadorDePrecos();

		calculador.realizaCalculo(permanencia, precoDaPermanencia);

		BigDecimal precoEsperado = new BigDecimal("7.00");

		Assert.assertEquals(precoEsperado, calculador.getTotalApagar());

	}

	@Test
	public void testaValorDaPermaneciaDoCarroPorDiaria() {

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento);

		Precos precoDaPermanencia = new Carro();

		CalculadorDePrecos calculador = new CalculadorDePrecos();

		calculador.realizaCalculo(permanencia, precoDaPermanencia);

		BigDecimal precoEsperado = new BigDecimal("18.00");

		Assert.assertEquals(precoEsperado, calculador.getTotalApagar());

	}

}

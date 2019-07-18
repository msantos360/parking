package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaValorDaPermanenciaDeVeiculo {

	Permanencia permanencia;
	Calendar saidaDoVeiculoDoEstacionamento = Calendar.getInstance();
	Calendar entradaDoVeiculoNoEstacionamento = Calendar.getInstance();

	@Before
	public void dadosDeEntrada() {
		entradaDoVeiculoNoEstacionamento.set(Calendar.DAY_OF_MONTH, 10);
		entradaDoVeiculoNoEstacionamento.set(Calendar.HOUR, 10);
		entradaDoVeiculoNoEstacionamento.set(Calendar.MINUTE, 30);
	}

	@Test
	public void testaValorDaPermaneciaDoCarroPorAte60minutos() {
		saidaDoVeiculoDoEstacionamento.set(Calendar.DAY_OF_MONTH, 10);
		saidaDoVeiculoDoEstacionamento.set(Calendar.HOUR, 11);
		saidaDoVeiculoDoEstacionamento.set(Calendar.MINUTE, 30);

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento, saidaDoVeiculoDoEstacionamento);
		Precos precoDaPermanencia = new Carro();
		CalculadorDePrecos calculador = new CalculadorDePrecos();

		calculador.realizaCalculo(permanencia, precoDaPermanencia);

		BigDecimal precoEsperado = new BigDecimal("10.00");

		Assert.assertEquals(precoEsperado, calculador.getTotalApagar());

	}
	
	@Test
	public void testaValorDaPermaneciaDoCarroAcimaDe60minutosMaisOAcrecimoDoValorDaPrimeiraHora() {
		saidaDoVeiculoDoEstacionamento.set(Calendar.DAY_OF_MONTH, 10);
		saidaDoVeiculoDoEstacionamento.set(Calendar.HOUR, 12);
		saidaDoVeiculoDoEstacionamento.set(Calendar.MINUTE, 10);

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento, saidaDoVeiculoDoEstacionamento);
		Precos precoDaPermanencia = new Carro();
		CalculadorDePrecos calculador = new CalculadorDePrecos();

		calculador.realizaCalculo(permanencia, precoDaPermanencia);

		BigDecimal precoEsperado = new BigDecimal("12.00");

		Assert.assertEquals(precoEsperado, calculador.getTotalApagar());

	}
	
	@Test
	public void testaValorDaPermaneciaDoCarroPorDiaria() {
		saidaDoVeiculoDoEstacionamento.set(Calendar.DAY_OF_MONTH, 12);
		saidaDoVeiculoDoEstacionamento.set(Calendar.HOUR, 10);
		saidaDoVeiculoDoEstacionamento.set(Calendar.MINUTE, 30);

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento, saidaDoVeiculoDoEstacionamento);
		
		Precos precoDaPermanencia = new Carro();
		
		CalculadorDePrecos calculador = new CalculadorDePrecos();

		calculador.realizaCalculo(permanencia, precoDaPermanencia);

		BigDecimal precoEsperado = new BigDecimal("18.00");

		Assert.assertEquals(precoEsperado, calculador.getTotalApagar());

	}

}

package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaValorDaPermanenciaDeVeiculo {

	private Permanencia permanencia;

	private LocalDateTime entradaDoVeiculoNoEstacionamento;
	
	private LocalDateTime saidaDoVeiculoDoEstacionamento;

	@Test
	public void testaValorDaPermaneciaDoCarroPorAte60minutos() {
		
		entradaDoVeiculoNoEstacionamento = LocalDateTime.of(2019, 02, 28, 10, 00);
		saidaDoVeiculoDoEstacionamento = LocalDateTime.of(2019, 02, 28, 11, 00);

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento, saidaDoVeiculoDoEstacionamento);
		Precos precoDaPermanencia = new Carro();
		CalculadorDePrecos calculador = new CalculadorDePrecos();

		calculador.realizaCalculo(permanencia, precoDaPermanencia);

		BigDecimal precoEsperado = new BigDecimal("5.00");

		Assert.assertEquals(precoEsperado, calculador.getTotalApagar());

	}
	
	@Test
	public void testaValorDaPermaneciaDoCarroAcimaDe60minutosMaisOAcrecimoDoValorDaPrimeiraHora() {

		entradaDoVeiculoNoEstacionamento = LocalDateTime.of(2019, 02, 28, 10, 00);
		saidaDoVeiculoDoEstacionamento = LocalDateTime.of(2019, 02, 28, 12, 00);
		
		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento, saidaDoVeiculoDoEstacionamento);
		Precos precoDaPermanencia = new Carro();
		CalculadorDePrecos calculador = new CalculadorDePrecos();

		calculador.realizaCalculo(permanencia, precoDaPermanencia);

		BigDecimal precoEsperado = new BigDecimal("7.00");

		Assert.assertEquals(precoEsperado, calculador.getTotalApagar());

	}
	
	@Test
	public void testaValorDaPermaneciaDoCarroPorDiaria() {
		
		entradaDoVeiculoNoEstacionamento = LocalDateTime.of(2019, 02, 28, 10, 00);
		saidaDoVeiculoDoEstacionamento = LocalDateTime.of(2019, 03, 02, 10, 00);

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento, saidaDoVeiculoDoEstacionamento);
		
		Precos precoDaPermanencia = new Carro();
		
		CalculadorDePrecos calculador = new CalculadorDePrecos();

		calculador.realizaCalculo(permanencia, precoDaPermanencia);

		BigDecimal precoEsperado = new BigDecimal("18.00");

		Assert.assertEquals(precoEsperado, calculador.getTotalApagar());

	}
	
}

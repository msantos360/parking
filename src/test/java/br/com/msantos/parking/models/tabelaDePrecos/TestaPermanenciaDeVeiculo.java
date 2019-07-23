package br.com.msantos.parking.models.tabelaDePrecos;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaPermanenciaDeVeiculo {

	private Permanencia permanencia;

	private Calendar entradaDoVeiculoNoEstacionamento;

	@Test
	public void calculaPermanenciaDeVeiculoEmMinutos() {

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento);

		Long permanenciaDoveiculoNoEstacionamento = permanencia.calculaPermanenciaEmMinutos();

		System.out.println("Permanencia em minutos: " + permanenciaDoveiculoNoEstacionamento);

		Long permanenciaEsperada = (long) 60;
		Assert.assertEquals(permanenciaEsperada, permanenciaDoveiculoNoEstacionamento);
	}

	/**
	 * Teste da diaria referente ao mês de fevereiro entrando no dia 28/FEV e saindo
	 * 01/MAR
	 **/
	@Test
	public void calculaPermanenciaDeVeiculoEmDiasEmFevereiro() {

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento);

		Long permanenciaDoveiculoNoEstacionamento = permanencia.calculaPermanenciaEmDias();

		System.out.println("Permanencia em dias: " + permanenciaDoveiculoNoEstacionamento);

		Long permanenciaEsperada = (long) 1;
		Assert.assertEquals(permanenciaEsperada, permanenciaDoveiculoNoEstacionamento);
	}

}

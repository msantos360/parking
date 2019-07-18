package br.com.msantos.parking.models.tabelaDePrecos;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaPermanenciaDeVeiculo {

	Permanencia permanencia;

	@Before
	public void dadosDeEntrada() {
		Calendar entradaDoVeiculoNoEstacionamento = Calendar.getInstance();

		entradaDoVeiculoNoEstacionamento.set(Calendar.HOUR, 10);
		entradaDoVeiculoNoEstacionamento.set(Calendar.MINUTE, 30);

		Calendar saidaDoVeiculoDoEstacionamento = Calendar.getInstance();

		saidaDoVeiculoDoEstacionamento.set(Calendar.HOUR, 14);
		saidaDoVeiculoDoEstacionamento.set(Calendar.MINUTE, 30);

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento, saidaDoVeiculoDoEstacionamento);
	}

	@Test
	public void calculaPermanenciaDeVeiculoEmMinutos() {

		Long permanenciaDoveiculoNoEstacionamento = permanencia.calculaPermanenciaEmMinutos();

		System.out.println("Permanencia em minutos: " + permanenciaDoveiculoNoEstacionamento);

		Long permanenciaEsperada = (long) 240;
		Assert.assertEquals(permanenciaEsperada, permanenciaDoveiculoNoEstacionamento);
	}

	@Test
	public void calculaPermanenciaDeVeiculoEmHoras() {

		Long permanenciaDoveiculoNoEstacionamento = permanencia.calculaPermanenciaEmHoras();

		System.out.println("Permanencia em horas: " + permanenciaDoveiculoNoEstacionamento);

		Long permanenciaEsperada = (long) 4;
		Assert.assertEquals(permanenciaEsperada, permanenciaDoveiculoNoEstacionamento);
	}
	
	@Test
	public void calculaPermanenciaDeVeiculoEmDias() {
		Calendar entradaDoVeiculoNoEstacionamento = Calendar.getInstance();
		entradaDoVeiculoNoEstacionamento.set(Calendar.DAY_OF_MONTH, 15);

		Calendar saidaDoVeiculoDoEstacionamento = Calendar.getInstance();

		saidaDoVeiculoDoEstacionamento.set(Calendar.DAY_OF_MONTH, 20);

		Permanencia permanenciaEmDias = new Permanencia(entradaDoVeiculoNoEstacionamento, saidaDoVeiculoDoEstacionamento);
		Long permanenciaDoveiculoNoEstacionamento = permanenciaEmDias.calculaPermanenciaEmDias();

		System.out.println("Permanencia em Dias: " + permanenciaDoveiculoNoEstacionamento);

		Long permanenciaEsperada = (long) 5;
		Assert.assertEquals(permanenciaEsperada, permanenciaDoveiculoNoEstacionamento);
	}
}

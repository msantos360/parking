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

	@Test
	public void calculaPermanenciaDeVeiculoEmMinutos() {

		Calendar entradaDoVeiculoNoEstacionamento = Calendar.getInstance();

		entradaDoVeiculoNoEstacionamento.set(Calendar.HOUR, 10);
		entradaDoVeiculoNoEstacionamento.set(Calendar.MINUTE, 30);

		Calendar saidaDoVeiculoDoEstacionamento = Calendar.getInstance();

		saidaDoVeiculoDoEstacionamento.set(Calendar.HOUR, 14);
		saidaDoVeiculoDoEstacionamento.set(Calendar.MINUTE, 30);

		Permanencia permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento, saidaDoVeiculoDoEstacionamento);

		Long permanenciaDoveiculoNoEstacionamento = permanencia.calculaPermanenciaEmMinutos();

		System.out.println("Permanencia em minutos: " + permanenciaDoveiculoNoEstacionamento);
		
		Long permanenciaEsperada = (long) 240;
		
		Assert.assertEquals(permanenciaEsperada, permanenciaDoveiculoNoEstacionamento);
	}
	
	@Test
	public void calculaPermanenciaDeVeiculoEmHoras() {

		Calendar entradaDoVeiculoNoEstacionamento = Calendar.getInstance();

		entradaDoVeiculoNoEstacionamento.set(Calendar.HOUR, 10);
		entradaDoVeiculoNoEstacionamento.set(Calendar.MINUTE, 30);

		Calendar saidaDoVeiculoDoEstacionamento = Calendar.getInstance();

		saidaDoVeiculoDoEstacionamento.set(Calendar.HOUR, 14);
		saidaDoVeiculoDoEstacionamento.set(Calendar.MINUTE, 30);

		Permanencia permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento, saidaDoVeiculoDoEstacionamento);

		Long permanenciaDoveiculoNoEstacionamento = permanencia.calculaPermanenciaEmHoras();

		System.out.println("Permanencia em horas: " + permanenciaDoveiculoNoEstacionamento);
		
		Long permanenciaEsperada = (long) 4;
		
		Assert.assertEquals(permanenciaEsperada, permanenciaDoveiculoNoEstacionamento);
	}
}

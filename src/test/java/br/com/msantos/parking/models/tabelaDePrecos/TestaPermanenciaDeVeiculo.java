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

	private Calendar entradaDoVeiculoNoEstacionamento = Calendar.getInstance();

	@Test
	public void calculaPermanenciaDeVeiculoEmMinutos() {

		entradaDoVeiculoNoEstacionamento.set(2019, Calendar.JULY, 29, 8, 30);

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento);

		Long permanenciaEsperada = (long) 60;
		
		System.out.println(permanencia);

		Assert.assertEquals(permanenciaEsperada, permanencia.getPermanenciaEmMinutos());
	}

	@Test
	public void calculaPermanenciaDeVeiculoEmDias() {

		entradaDoVeiculoNoEstacionamento.set(2019, Calendar.JULY, 28);

		permanencia = new Permanencia(entradaDoVeiculoNoEstacionamento);

		Long permanenciaEsperada = (long) 1;

		System.out.println(permanencia);
		
		Assert.assertEquals(permanenciaEsperada, permanencia.getPermanenciaEmDias());
	}

}

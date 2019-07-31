package br.com.msantos.parking.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.msantos.parking.models.VagasDisponiveisParking;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteVagasDisponiveis {

	@Autowired
	MovimentacoesRepository movimentacoesRepository;

	@Autowired
	EstacionamentoRepository estacionamentoRepository;

	@Test
	public void vagasDisponiveisPorEstacionamento() {

		Long estacionamentoId = (long) 1;
		Boolean autorizaEntrada = new VagasDisponiveisParking().autorizaEntrada(estacionamentoId,
				movimentacoesRepository, estacionamentoRepository);

		Boolean autorizacaoEsperada = true;

		Assert.assertEquals(autorizacaoEsperada, autorizaEntrada);
	}

	@Test
	public void vagasOcupadasPorEstacionamento() {

		Long estacionamentoId = (long) 1;
		Boolean autorizaEntrada = new VagasDisponiveisParking().autorizaEntrada(estacionamentoId,
				movimentacoesRepository, estacionamentoRepository);

		Boolean autorizacaoEsperada = false;

		Assert.assertEquals(autorizacaoEsperada, autorizaEntrada);
	}
}

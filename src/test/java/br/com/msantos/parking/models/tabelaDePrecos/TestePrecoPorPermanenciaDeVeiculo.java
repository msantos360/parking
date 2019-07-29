package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.repository.MovimentacoesRepository;
import br.com.msantos.parking.repository.TabelaDePrecosRepository;
import br.com.msantos.parking.repository.VeiculoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestePrecoPorPermanenciaDeVeiculo {

	@Autowired
	private TabelaDePrecosRepository tabelaDePrecosRepository;

	@Autowired
	private MovimentacoesRepository movimentacoesRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	Optional<Movimentacoes> movimentacoes;

	BigDecimal totalApagar;

	Carro carro;

	@Before
	public void calculador() {
		
		movimentacoes = movimentacoesRepository.findById((long) 12);

		carro = new Carro(tabelaDePrecosRepository, movimentacoes.get(), veiculoRepository);

		totalApagar = new CalculadorDePrecos().realizaCalculo(carro);
	}

	@Test
	public void testaPrecoPorTipoDeVeiculoEPorEstacionamento() {

		Double precoDaDiaria = 10.00;
		Double precoDaMensalidade = 180.00;
		Double precoDaPrimeiraHora = 6.00;
		Double precoDasDemaisHoras = 2.00;

		Assert.assertEquals(precoDaDiaria, carro.getPrecoDaDiaria());
		Assert.assertEquals(precoDaMensalidade, carro.getPrecoDaMensalidade());
		Assert.assertEquals(precoDaPrimeiraHora, carro.getPrecoDaPrimeiraHora());
		Assert.assertEquals(precoDasDemaisHoras, carro.getPrecoDasDemaisHoras());

	}

	@Test
	public void testaTotalApagarPorPermanenciaDeCarro() {

		BigDecimal totalApagarEsperado = BigDecimal.valueOf(20.00);

		Assert.assertEquals(totalApagarEsperado.setScale(2, RoundingMode.HALF_UP), totalApagar);
	}

}

package br.com.msantos.parking.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.msantos.parking.models.Veiculo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteVeiculoRepository {
	
	@Autowired
	VeiculoRepository veiculoRepository;

	@Test
	public void achaVeiculoPeloNumeroDaPlaca() {
		Veiculo veiculo = veiculoRepository.findByPlaca("GGR-3988");
		
		Long idClienteEsperado = (long) 10;
		Long idVeiculoEsperado = (long) 7;
		String placaEsperada = "GGR-3988";
		
		Assert.assertEquals(idClienteEsperado, veiculo.getCliente().getId());
		Assert.assertEquals(idVeiculoEsperado, veiculo.getId());
		Assert.assertEquals(placaEsperada, veiculo.getPlaca());
	}
}

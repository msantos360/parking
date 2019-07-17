package br.com.msantos.parking;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.msantos.parking.models.Cliente;
import br.com.msantos.parking.models.TipoVeiculo;
import br.com.msantos.parking.models.Veiculo;
import br.com.msantos.parking.repository.ClienteRepository;
import br.com.msantos.parking.repository.VeiculoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingApplicationTests {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Test
	public void contextLoads() {
		
		Long id = (long) 2;
		
		Optional<Cliente> cliente = clienteRepository.findById(id); 
		
		Cliente paulo = cliente.get();
		
		Veiculo veiculo = new Veiculo("Gol G5", "vw", "GHT-8596", TipoVeiculo.CARRO, paulo);
		
		veiculoRepository.save(veiculo);
		
		
	}


}

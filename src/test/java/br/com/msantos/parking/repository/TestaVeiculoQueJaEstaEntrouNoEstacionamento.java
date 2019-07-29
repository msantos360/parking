package br.com.msantos.parking.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.Veiculo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaVeiculoQueJaEstaEntrouNoEstacionamento {

	@Autowired
	MovimentacoesRepository movimentacoesRepository;

	@Autowired
	VeiculoRepository veiculoRepository;

	@Test
	public void achaVeiculoQueJaEntrouNoEstacionamento() {

		Veiculo veiculo = veiculoRepository.findByPlaca("HDH-7755");

		Movimentacoes findVeiculoJaAlocado = movimentacoesRepository.findVeiculoJaAlocado(veiculo);

		if (findVeiculoJaAlocado != null) {
			
			System.out.println("Veiculo já entrou no estacionamento");
			System.out.println(findVeiculoJaAlocado.getHorarioEntrada().getTime());
			
		} else {
			
			System.out.println("Permitir a entrada");
		}
	}
}

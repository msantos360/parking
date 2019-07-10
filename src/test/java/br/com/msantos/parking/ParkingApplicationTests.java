package br.com.msantos.parking;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.msantos.parking.models.Cliente;
import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.TipoCliente;
import br.com.msantos.parking.models.TipoVeiculo;
import br.com.msantos.parking.models.Veiculo;
import br.com.msantos.parking.repository.ClienteRepository;
import br.com.msantos.parking.repository.MovimentacoesRepository;
import br.com.msantos.parking.repository.VeiculoRepository;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingApplicationTests {

	@Autowired
	ClienteRepository clienteR;

	@Autowired
	MovimentacoesRepository movimentacoesR;

	@Autowired
	VeiculoRepository veiculoR;

	Calendar dataHoje = Calendar.getInstance();

	@Test
	public void contextLoads() {

		clienteR.save(controiCliente());

//		Veiculo pajero = veiculoR.save(constroiVeiculo(joao));
//
//		Movimentacoes movimentacao = movimentacoesR.save(realizaMovimentacao(joao, pajero));
		
	}

	public Movimentacoes realizaMovimentacao(Cliente cliente, Veiculo veiculo) {

		Calendar horarioSaida = Calendar.getInstance();

		horarioSaida.set(Calendar.DAY_OF_MONTH, 11);

		Movimentacoes movimentacaoJoao = new Movimentacoes(Calendar.getInstance(), horarioSaida, BigDecimal.TEN,
				cliente, veiculo);
		
		return movimentacaoJoao;

	}

	public Veiculo constroiVeiculo(Cliente cliente) {

		Veiculo veiculo = new Veiculo("Pajero TR4", "Mitsubishi", "HJU-6677", TipoVeiculo.CARRO, cliente);

		return veiculo;
	}

	public Cliente controiCliente() {

		Calendar dataNascimento = Calendar.getInstance();

		dataNascimento.set(Calendar.YEAR, 2000);
		dataNascimento.set(Calendar.MONTH, Calendar.DECEMBER);
		dataNascimento.set(Calendar.DAY_OF_MONTH, 07);

		Cliente cliente = new Cliente("Ana Lopes", Long.parseLong("16948595233"), dataNascimento, dataHoje,
				TipoCliente.NORMAL);

		return cliente;
	}

}

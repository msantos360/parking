package br.com.msantos.parking.repository;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.msantos.parking.models.Estacionamento;
import br.com.msantos.parking.models.TabelaDePrecos;
import br.com.msantos.parking.models.TipoVeiculo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaTabelaDePrecosRepository {

	@Autowired
	TabelaDePrecosRepository tabelaDePrecosRepository;

	@Autowired
	EstacionamentoRepository estacionamentoRepository;

	Long estacionamentoId = (long) 1;

	@Test
	public void testaSelectComRetornoDosValoresDaTabelaDePrecos() {

		Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(estacionamentoId);

		TabelaDePrecos precosCarro = tabelaDePrecosRepository.findByTipoAndEstacionamento(TipoVeiculo.CARRO,
				estacionamento.get());

		System.out.println("Diaria " + precosCarro.getPrecoDaDiaria());
		System.out.println("Mensalidade " + precosCarro.getPrecoMensalidade());
		System.out.println("Primeira Hora " + precosCarro.getPrecoDaPrimeiraHora());
		System.out.println("Demais horas " + precosCarro.getPrecoDasDemaisHoras());

	}
}

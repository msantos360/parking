package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;

import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.repository.TabelaDePrecosRepository;

public interface Precos {

	BigDecimal calculaValorDaPermanencia(Permanencia permanencia);

	void tabelaDePrecosPorVeiculo(TabelaDePrecosRepository tabelaDePrecosRepository, Movimentacoes movimentacoes);
}

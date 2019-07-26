package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;
import java.util.List;

import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.TabelaDePrecos;
import br.com.msantos.parking.models.TipoVeiculo;
import br.com.msantos.parking.repository.TabelaDePrecosRepository;

public class Carro extends TemplateCalculadoraDePrecos implements Precos {

	public Carro(TabelaDePrecosRepository tabelaDePrecosRepository, Movimentacoes movimentacoes) {
		
		super(tabelaDePrecosRepository, movimentacoes);
		getPrecosPorVeiculo();
	}

	@Override
	public BigDecimal getPrecosPorVeiculo() {

		Long estacionamentoId = movimentacoes.getEstacionamento().getId();
		List<TabelaDePrecos> tabelaPrecosCarro = tabelaDePrecosRepository.findByTipo(TipoVeiculo.CARRO);

		
		for (TabelaDePrecos tabelaDePrecos : tabelaPrecosCarro) {
			
			if(tabelaDePrecos.getEstacionamento().getId().equals(estacionamentoId)) {
				
				precoDaPrimeiraHora = tabelaDePrecos.getPrecoDaPrimeiraHora().doubleValue();
				precoDasDemaisHoras = tabelaDePrecos.getPrecoDasDemaisHoras().doubleValue();
				precoDaDiaria = tabelaDePrecos.getPrecoDaDiaria().doubleValue();
				precoDaMensalidade = tabelaDePrecos.getPrecoMensalidade().doubleValue();
			}
			
		}
		
		calculaValorDaPermanencia(new Permanencia(movimentacoes.getHorarioEntrada()));
		
		return getTotalApagar();

	}
}

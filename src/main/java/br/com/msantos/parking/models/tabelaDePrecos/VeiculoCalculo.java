package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.TabelaDePrecos;
import br.com.msantos.parking.models.Veiculo;
import br.com.msantos.parking.repository.TabelaDePrecosRepository;
import br.com.msantos.parking.repository.VeiculoRepository;

public class VeiculoCalculo extends TemplateCalculadoraDePrecos implements Precos {

	public VeiculoCalculo(TabelaDePrecosRepository tabelaDePrecosRepository, Movimentacoes movimentacoes,
			VeiculoRepository veiculoRepository) {

		super(tabelaDePrecosRepository, movimentacoes, veiculoRepository);
		getPrecosPorVeiculo();
	}

	@Override
	public BigDecimal getPrecosPorVeiculo() {

		Optional<Veiculo> tipoVeiculo = veiculoRepository.findById(movimentacoes.getVeiculo().getId());

		TabelaDePrecos findByTipoAndEstacionamento = tabelaDePrecosRepository
				.findByTipoAndEstacionamento(tipoVeiculo.get().getTipo(), movimentacoes.getEstacionamento());

		precoDaPrimeiraHora = findByTipoAndEstacionamento.getPrecoDaPrimeiraHora().doubleValue();
		precoDasDemaisHoras = findByTipoAndEstacionamento.getPrecoDasDemaisHoras().doubleValue();
		precoDaDiaria = findByTipoAndEstacionamento.getPrecoDaDiaria().doubleValue();
		precoDaMensalidade = findByTipoAndEstacionamento.getPrecoMensalidade().doubleValue();

		calculaValorDaPermanencia(new Permanencia(movimentacoes.getHorarioEntrada()));

		return getTotalApagar();

	}

}

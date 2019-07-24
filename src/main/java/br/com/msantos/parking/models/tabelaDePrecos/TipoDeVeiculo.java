package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.TipoVeiculo;
import br.com.msantos.parking.models.Veiculo;
import br.com.msantos.parking.repository.TabelaDePrecosRepository;
import br.com.msantos.parking.repository.VeiculoRepository;

public class TipoDeVeiculo {

	private BigDecimal totalApagar;

	public BigDecimal getTotalApagar() {
		return totalApagar.setScale(2, RoundingMode.HALF_UP);
	}

	public void veiculo(Movimentacoes movimentacao, VeiculoRepository veiculoRepository,
			TabelaDePrecosRepository tabelaDePrecosRepository) {

		Optional<Veiculo> tipoDoVeiculo = veiculoRepository.findById(movimentacao.getVeiculo().getId());

		Permanencia permanencia = new Permanencia(movimentacao.getHorarioEntrada());

		if (tipoDoVeiculo.get().getTipo().equals(TipoVeiculo.CARRO)) {
			this.totalApagar = new CalculadorDePrecos().realizaCalculo(permanencia,
					new Carro(tabelaDePrecosRepository));

		}
//		if (tipoDoVeiculo.get().getTipo().equals(TipoVeiculo.CARRO_SUV)) {
//			this.totalApagar = new CalculadorDePrecos().realizaCalculo(permanencia,
//					new Carro(tabelaDePrecosRepository));
//		}

	}
}

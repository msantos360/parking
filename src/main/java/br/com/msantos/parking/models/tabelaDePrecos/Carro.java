package br.com.msantos.parking.models.tabelaDePrecos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.TabelaDePrecos;
import br.com.msantos.parking.repository.TabelaDePrecosRepository;

public class Carro implements Precos {

	private Double precoDaPrimeiraHora;

	private Double precoDaDiaria;

	private Double precoDasDemaisHoras;

	private Double precoDaMensalidade;

	private BigDecimal totalApagar;

	public Carro(TabelaDePrecosRepository tabelaDePrecosRepository, Movimentacoes movimentacoes) {
		tabelaDePrecosPorVeiculo(tabelaDePrecosRepository, movimentacoes);
	}

	public BigDecimal getTotalApagar() {
		return totalApagar.setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal calculaValorDaPermanencia(Permanencia permanencia) {

//		/** tolerancia de 10 minutos = R$ ZERO **/
//		if (permanencia.calculaPermanenciaEmMinutos() <= 10) {
//			return totalApagar = BigDecimal.ZERO;
//		}

		/** valor da primeira hora R$ **/
		if (permanencia.getPermanenciaEmMinutos() <= 60) {
			return totalApagar = BigDecimal.valueOf(precoDaPrimeiraHora);

		}
		/** valor da segunda hora + a primeira hora R$ **/
		if (permanencia.getPermanenciaEmMinutos() < 1440) {
			return totalApagar = BigDecimal
					.valueOf((permanencia.calculaPermanenciaEmMinutos() - 60) * (precoDasDemaisHoras / 60)
							+ precoDaPrimeiraHora);
		}

		/** valor da diaria R$ **/
		else {

			return totalApagar = BigDecimal.valueOf(permanencia.calculaPermanenciaEmDias() * precoDaDiaria);
		}
	}

	@Override
	public void tabelaDePrecosPorVeiculo(TabelaDePrecosRepository tabelaDePrecosRepository, Movimentacoes movimentacoes) {
		
		//resolver a localização do estacionamento por preço
		Long id = movimentacoes.getEstacionamento().getId();
		Optional<TabelaDePrecos> tabelaPrecosCarro = tabelaDePrecosRepository.findById(id);

		precoDaPrimeiraHora = tabelaPrecosCarro.get().getPrecoDaPrimeiraHora().doubleValue();
		precoDasDemaisHoras = tabelaPrecosCarro.get().getPrecoDasDemaisHoras().doubleValue();
		precoDaDiaria = tabelaPrecosCarro.get().getPrecoDaDiaria().doubleValue();
		precoDaMensalidade = tabelaPrecosCarro.get().getPrecoMensalidade().doubleValue();

	}
}

package br.com.msantos.parking.forms;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.Estacionamento;
import br.com.msantos.parking.models.TabelaDePrecos;
import br.com.msantos.parking.models.TipoVeiculo;
import br.com.msantos.parking.repository.EstacionamentoRepository;

public class TabelaDePrecosForm {

	@NotNull
	private TipoVeiculo tipo;

	@NotNull
	private BigDecimal precoDaPrimeiraHora;

	@NotNull
	private BigDecimal precoDasDemaisHoras;

	@NotNull
	private BigDecimal precoDaDiaria;

	@NotNull
	private BigDecimal precoMensalidade;

	@NotNull
	private Long estacionamentoId;

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

	public void setPrecoDaPrimeiraHora(BigDecimal precoDaPrimeiraHora) {
		this.precoDaPrimeiraHora = precoDaPrimeiraHora;
	}

	public void setPrecoDasDemaisHoras(BigDecimal precoDasDemaisHoras) {
		this.precoDasDemaisHoras = precoDasDemaisHoras;
	}

	public void setPrecoDaDiaria(BigDecimal precoDaDiaria) {
		this.precoDaDiaria = precoDaDiaria;
	}

	public void setPrecoMensalidade(BigDecimal precoMensalidade) {
		this.precoMensalidade = precoMensalidade;
	}

	public void setEstacionamentoId(Long estacionamentoId) {
		this.estacionamentoId = estacionamentoId;
	}

	public TabelaDePrecos conterter(TabelaDePrecosForm form, EstacionamentoRepository estacionamentoRepository) {

		Optional<Estacionamento> achaEstacionamentoPorId = estacionamentoRepository.findById(estacionamentoId);

		return new TabelaDePrecos(tipo, precoDaPrimeiraHora, precoDasDemaisHoras, precoDaDiaria, precoMensalidade,
				achaEstacionamentoPorId.get());
	}

}

package br.com.msantos.parking.forms;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.msantos.parking.models.TabelaDePrecos;
import br.com.msantos.parking.models.TipoVeiculo;
import br.com.msantos.parking.repository.TabelaDePrecosRepository;

public class AtualizacaoTabelaDePrecosForm {

	@NotNull
	private TipoVeiculo tipo;

	@NotNull
	private BigDecimal precoDaPrimeiraHora;

	@NotNull
	private BigDecimal precoDasDemaisHoras;

	private BigDecimal precoDaDiaria;

	private BigDecimal precoMensalidade;

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

	public TabelaDePrecos atualiza(Long id, TabelaDePrecosRepository tabelaDePrecosRepository) {

		TabelaDePrecos tabelaDePrecos = tabelaDePrecosRepository.getOne(id);
		tabelaDePrecos.setTipo(tipo);
		tabelaDePrecos.setPrecoDaPrimeiraHora(precoDaPrimeiraHora);
		tabelaDePrecos.setPrecoDasDemaisHoras(precoDasDemaisHoras);
		tabelaDePrecos.setPrecoDaDiaria(precoDaDiaria);
		tabelaDePrecos.setPrecoMensalidade(precoMensalidade);

		return tabelaDePrecos;
	}

}

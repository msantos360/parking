package br.com.msantos.parking.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estacionamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Integer capacidadeVagas;

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private Long cnpj;
	
	@OneToMany(mappedBy = "estacionamento")
	private List<TabelaDePrecos> tabelaDePrecos;
	
	@OneToMany(mappedBy = "estacionamento")
	private List<Movimentacoes> movimentacoes;

	/** Hibernate only **/
	@Deprecated
	public Estacionamento() {

	}

	public Estacionamento(String nome, Integer capacidadeVagas, Long cnpj) {
		this.nome = nome;
		this.capacidadeVagas = capacidadeVagas;
		this.cnpj = cnpj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCapacidadeVagas() {
		return capacidadeVagas;
	}

	public void setCapacidadeVagas(Integer capacidadeVagas) {
		this.capacidadeVagas = capacidadeVagas;
	}
	
	public void setMovimentacoes(List<Movimentacoes> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public List<TabelaDePrecos> getTabelaDePrecos() {
		return tabelaDePrecos;
	}

	public void setTabelaDePrecos(List<TabelaDePrecos> tabelaDePrecos) {
		this.tabelaDePrecos = tabelaDePrecos;
	}
	
	public List<Movimentacoes> getMovimentacoes() {
		return movimentacoes;
	}

}

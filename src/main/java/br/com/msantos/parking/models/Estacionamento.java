package br.com.msantos.parking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estacionamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Integer capacidadeVagas;

	@Column(nullable = false)
	private String nome;

	/** Hibernate only **/
	@Deprecated
	public Estacionamento() {

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

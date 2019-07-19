package br.com.msantos.parking.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msantos.parking.models.Estacionamento;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {

	Page<Estacionamento> findByNome(String nome, Pageable paginacao);

	
	
}

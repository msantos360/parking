package br.com.msantos.parking.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msantos.parking.models.TabelaDePrecos;
import br.com.msantos.parking.models.TipoVeiculo;

public interface TabelaDePrecosRepository extends JpaRepository<TabelaDePrecos, Long> {

	Page<TabelaDePrecos> findByEstacionamento_Id(Long tipo, Pageable paginacao);
	
	List<TabelaDePrecos> findByTipo(TipoVeiculo tipo);
	
}

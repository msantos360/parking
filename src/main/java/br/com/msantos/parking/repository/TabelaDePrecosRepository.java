package br.com.msantos.parking.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.msantos.parking.models.Estacionamento;
import br.com.msantos.parking.models.TabelaDePrecos;
import br.com.msantos.parking.models.TipoVeiculo;

public interface TabelaDePrecosRepository extends JpaRepository<TabelaDePrecos, Long> {

	Page<TabelaDePrecos> findByEstacionamento_Id(Long tipo, Pageable paginacao);

	List<TabelaDePrecos> findByTipo(TipoVeiculo tipo);

	@Query("select t from TabelaDePrecos t where t.tipo = :tipo and t.estacionamento = :estacionamento")
	TabelaDePrecos findByTipoAndEstacionamento(@Param("tipo") TipoVeiculo tipo,
			@Param("estacionamento") Estacionamento estacionamento);

}

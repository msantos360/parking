package br.com.msantos.parking.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msantos.parking.models.TabelaDePrecos;

public interface TabelaDePrecosRepository extends JpaRepository<TabelaDePrecos, Long> {

	Page<TabelaDePrecos> findByEstacionamento_Id(Long tipo, Pageable paginacao);

}

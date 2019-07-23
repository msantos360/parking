package br.com.msantos.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msantos.parking.models.Movimentacoes;

public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long> {


}

package br.com.msantos.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.msantos.parking.models.Estacionamento;
import br.com.msantos.parking.models.Movimentacoes;
import br.com.msantos.parking.models.Veiculo;

public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long> {

	@Query("select m from Movimentacoes m where m.horarioSaida is null and m.veiculo = :veiculo")
	Movimentacoes findVeiculoJaAlocado(@Param("veiculo") Veiculo veiculo);

	@Query("select m from Movimentacoes m where m.horarioSaida is null and m.estacionamento = :estacionamento")
	List<Movimentacoes> vagasOcupadasPorEstacionamento(@Param("estacionamento") Estacionamento estacionamento);
}

package br.com.msantos.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msantos.parking.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}

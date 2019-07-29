package br.com.msantos.parking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msantos.parking.models.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

	Optional<Colaborador> findByEmail(String email);

}

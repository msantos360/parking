package br.com.msantos.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msantos.parking.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	
}

package br.com.msantos.parking.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msantos.parking.models.Pagamento;
import br.com.msantos.parking.models.StatusDePagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

	Page<Pagamento> findByStatus(StatusDePagamento status, Pageable paginacao);

}

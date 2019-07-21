package br.com.msantos.parking.models.tabelaDePrecos;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Permanencia {

	private LocalDateTime entrada;
	
	private LocalDateTime saida;

	public Permanencia(LocalDateTime entrada, LocalDateTime saida) {
		this.entrada = entrada;
		this.saida = saida;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}
	
	public Long calculaPermanenciaEmMinutos() {
		return ChronoUnit.MINUTES.between(entrada, saida);
	}
	
	public Long calculaPermanenciaEmHoras() {
		return ChronoUnit.HOURS.between(entrada, saida);
	}
	
	public Long calculaPermanenciaEmDias() {
		return ChronoUnit.DAYS.between(entrada, saida);
	}
	
	public Long calculaPermanenciaEmMeses() {
		return ChronoUnit.MONTHS.between(entrada, saida);
	}
	
}

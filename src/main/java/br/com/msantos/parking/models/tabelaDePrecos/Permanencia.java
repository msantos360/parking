package br.com.msantos.parking.models.tabelaDePrecos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.TimeZone;

public class Permanencia {

	private LocalDateTime entrada;

	private LocalDateTime saida = LocalDateTime.now();

	public Permanencia(Calendar entrada) {
		this.entrada = toLocalDateTime(entrada);
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

	private static LocalDateTime toLocalDateTime(Calendar calendar) {
		if (calendar == null) {
			return null;
		}
		TimeZone tz = calendar.getTimeZone();
		ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
		return LocalDateTime.ofInstant(calendar.toInstant(), zid);
	}

}

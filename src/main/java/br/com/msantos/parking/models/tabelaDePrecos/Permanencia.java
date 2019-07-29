package br.com.msantos.parking.models.tabelaDePrecos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.TimeZone;

public class Permanencia {

	private LocalDateTime entrada;

	private LocalDateTime saida = LocalDateTime.now();

	private Long permanenciaEmMinutos;

	private Long permanenciaEmHoras;

	private Long permanenciaEmDias;

	private Long permanenciaEmMeses;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public Permanencia(Calendar dataEHoraDaEntrada) {
		this.entrada = toLocalDateTime(dataEHoraDaEntrada);

		calculaPermanenciaEmMinutos();
		calculaPermanenciaEmHoras();
		calculaPermanenciaEmDias();
		calculaPermanenciaEmMeses();
	}

	public Long getPermanenciaEmMinutos() {
		return permanenciaEmMinutos;
	}

	public Long getPermanenciaEmHoras() {
		return permanenciaEmHoras;
	}

	public Long getPermanenciaEmDias() {
		return permanenciaEmDias;
	}

	public Long getPermanenciaEmMeses() {
		return permanenciaEmMeses;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public Long calculaPermanenciaEmMinutos() {
		permanenciaEmMinutos = ChronoUnit.MINUTES.between(entrada, saida);
		return permanenciaEmMinutos;
	}

	public Long calculaPermanenciaEmHoras() {
		permanenciaEmHoras = ChronoUnit.HOURS.between(entrada, saida);

		return permanenciaEmHoras;
	}

	public Long calculaPermanenciaEmDias() {
		permanenciaEmDias = ChronoUnit.DAYS.between(entrada, saida);

		return permanenciaEmDias;
	}

	public Long calculaPermanenciaEmMeses() {
		permanenciaEmMeses = ChronoUnit.MONTHS.between(entrada, saida);

		return permanenciaEmMeses;
	}

	private static LocalDateTime toLocalDateTime(Calendar calendar) {
		if (calendar == null) {
			return null;
		}
		TimeZone tz = calendar.getTimeZone();
		ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
		return LocalDateTime.ofInstant(calendar.toInstant(), zid);
	}

	@Override
	public String toString() {

		String dataEhoraEntrada = "Data e hora entrada: " + getEntrada().format(formatter);
		String dataEhoraSaida = "Data e hora saida: " + getSaida().format(formatter);

		String minutos = "Permanencia em minutos::: " + getPermanenciaEmMinutos();
		String horas = "Permanencia em horas  ::: " + getPermanenciaEmHoras();
		String dias = "Permanencia em dias   ::: " + getPermanenciaEmDias();
		String meses = "Permanencia em meses  ::: " + getPermanenciaEmMeses();

		return dataEhoraEntrada + "\n" + dataEhoraSaida + "\n" + minutos + "\n" + horas + "\n" + dias + "\n" + meses;
	}

}

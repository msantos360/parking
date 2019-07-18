package br.com.msantos.parking.models.tabelaDePrecos;

import java.util.Calendar;

public class Permanencia {

	private Calendar entrada;
	
	private Calendar saida;

	public Permanencia(Calendar entrada, Calendar saida) {
		this.entrada = entrada;
		this.saida = saida;
	}

	public Calendar getEntrada() {
		return entrada;
	}

	public Calendar getSaida() {
		return saida;
	}
	
	public Long calculaPermanenciaEmMinutos() {
		return (saida.getTimeInMillis() - entrada.getTimeInMillis())/60000;
	}
	
	public Long calculaPermanenciaEmHoras() {
		return (calculaPermanenciaEmMinutos())/60;
	}
	
	public Long calculaPermanenciaEmDias() {
		return (calculaPermanenciaEmHoras())/24;
	}
	
}

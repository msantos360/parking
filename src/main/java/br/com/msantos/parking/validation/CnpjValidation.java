package br.com.msantos.parking.validation;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class CnpjValidation {

	public static Boolean validaCnpj(String cnpj) {
		try {
			
			CNPJValidator validador = new CNPJValidator();
			validador.assertValid(cnpj);
			
			return true;
			
		} catch (InvalidStateException e) {
			return false;
		}
	}
}

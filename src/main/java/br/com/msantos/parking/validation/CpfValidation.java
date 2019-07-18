package br.com.msantos.parking.validation;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class CpfValidation {

	public static Boolean validaCpf(String cpf) {
		
		try {
			CPFValidator validator = new CPFValidator();
			validator.assertValid(cpf);
			
			return true;
			
		} catch (InvalidStateException e) {
			return false;
		}
		
	}
}

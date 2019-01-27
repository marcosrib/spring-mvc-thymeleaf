package com.estudo.boot.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.estudo.boot.web.domain.Departamento;

public class DepartamentoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Departamento.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Departamento departamento = (Departamento) target;
		String d = departamento.getNome();
		
		if(d.isEmpty() || d ==null) {
			errors.rejectValue("nome", "campo não pode ser vazio");
		}
		
	}

}

package com.estudo.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.estudo.boot.web.domain.Departamento;
import com.estudo.boot.web.service.DepartamentoService;
@Component
public class stringToDepartamentoConverter implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoService departamentoService;
	@Override
	public Departamento convert(String source) {
		if (source.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(source);
		return departamentoService.buscarPorId(id);
	}

}

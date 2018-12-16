package com.estudo.boot.web.service;

import java.util.List;

import com.estudo.boot.web.domain.Departamento;

public interface DepartamentoService {


	void salvar(Departamento departamento);

    void editar(Departamento departamento);

    void excluir(Long id);

    Departamento buscarPorId(Long id);
    
    List<Departamento> buscarTodos();

	boolean departamentoTemCargos(Long id);
	List<Departamento> findDepartamentoByNome(String nome);
	
}

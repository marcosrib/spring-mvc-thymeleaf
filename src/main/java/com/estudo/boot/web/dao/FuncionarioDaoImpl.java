package com.estudo.boot.web.dao;

import org.springframework.stereotype.Repository;

import com.estudo.boot.web.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}

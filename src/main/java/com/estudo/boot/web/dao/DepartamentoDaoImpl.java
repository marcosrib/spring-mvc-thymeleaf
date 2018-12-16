package com.estudo.boot.web.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.estudo.boot.web.domain.Departamento;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao {

	@Override
	public List<Departamento> findByNome(String nome) {

		TypedQuery<Departamento> query = getEntityManager()
			      .createQuery("SELECT c FROM Departamento c where c.nome like :nome", Departamento.class);
		query.setParameter("nome", nome);
			  List<Departamento> results = query.getResultList();

		return results;
	}

}

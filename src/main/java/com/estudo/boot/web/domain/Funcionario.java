package com.estudo.boot.web.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario extends AbstractEntity<Long> {

	@Column(name = "NOME", nullable = false, unique = true)
	private String nome;

	@Column(name = "SALARIO", nullable = false, columnDefinition = "DECIMAL(7,2)DEFAULT 0.00")
	private String salario;
	@Column(name = "DATA_ENTRADA", nullable = false, columnDefinition = "DATE")
	private String dataEntrada;
	@Column(name = "DATA_SAIDA", columnDefinition = "DATE")
	private String dataSaida;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ENDERECO_ID_FK")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name="CARGO_ID_FK")
	private Cargo cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cargo getCarco() {
		return cargo;
	}

	public void setCarco(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
}

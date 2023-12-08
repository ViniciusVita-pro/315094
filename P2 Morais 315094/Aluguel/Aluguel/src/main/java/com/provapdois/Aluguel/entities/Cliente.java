package com.provapdois.Aluguel.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_clientes")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	private String nome;
	private String cpf;
	private String celular;
	private String cnh;

	public Cliente() {

	}

	public Cliente(Long idCliente, String nome, String cpf, String celular, String cnh) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.cnh = cnh;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(celular, cnh, cpf, idCliente, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(celular, other.celular) && Objects.equals(cnh, other.cnh)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(idCliente, other.idCliente)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", celular=" + celular + ", cnh="
				+ cnh + "]";
	}
	
	

}

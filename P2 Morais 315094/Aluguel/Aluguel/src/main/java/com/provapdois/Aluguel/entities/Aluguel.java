package com.provapdois.Aluguel.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.provapdois.Aluguel.entities.pk.AluguelPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aluguel")
public class Aluguel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AluguelPK id = new AluguelPK();
	
	private String dtaluguel;
	private String dtdevolucao;
	private float valoraluguel;
	
	public Aluguel() {
		
	}
	
	public Aluguel(Carro carro, Cliente cliente, String dtaluguel, String dtdevolucao, Float valoraluguel) {
		super();
		id.setCarro(carro);
		id.setCliente(cliente);
		this.dtaluguel=dtaluguel;
		this.dtdevolucao=dtdevolucao;
		this.valoraluguel=valoraluguel;
	}

	@JsonIgnore
	public Carro getCarro() {
		return id.getCarro();
	}
	
	public void setCarro(Carro carro) {
		id.setCarro(carro) ;
	}

	public Cliente getCliente() {
		return id.getCliente();
	}
	
	public void setCliente(Cliente cliente) {
		id.setCliente(cliente) ;
	}

	public AluguelPK getId() {
		return id;
	}

	public void setId(AluguelPK id) {
		this.id = id;
	}

	public String getDtaluguel() {
		return dtaluguel;
	}

	public void setDtaluguel(String dtaluguel) {
		this.dtaluguel = dtaluguel;
	}

	public String getDtdevolucao() {
		return dtdevolucao;
	}

	public void setDtdevolucao(String dtdevolucao) {
		this.dtdevolucao = dtdevolucao;
	}

	public float getValoraluguel() {
		return valoraluguel;
	}

	public void setValoraluguel(float valoraluguel) {
		this.valoraluguel = valoraluguel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, valoraluguel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluguel other = (Aluguel) obj;
		return Objects.equals(id, other.id)
				&& Float.floatToIntBits(valoraluguel) == Float.floatToIntBits(other.valoraluguel);
	}
	
	

}

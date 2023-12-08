package com.provapdois.Aluguel.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carro")
public class Carro implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarro;
	private String marca;
	private String modelo;
	private String placa;
	private float valordiaria;
	
	public Carro() {
		
	}

	public Carro(Long idCarro, String marca, String modelo, String placa, float valordiaria) {
		super();
		this.idCarro = idCarro;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.valordiaria = valordiaria;
	}

	public Long getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Long idCarro) {
		this.idCarro = idCarro;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public float getValordiaria() {
		return valordiaria;
	}

	public void setValordiaria(float valordiaria) {
		this.valordiaria = valordiaria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCarro, marca, modelo, placa, valordiaria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(idCarro, other.idCarro) && Objects.equals(marca, other.marca)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(placa, other.placa)
				&& Float.floatToIntBits(valordiaria) == Float.floatToIntBits(other.valordiaria);
	}

	@Override
	public String toString() {
		return "Carro [idCarro=" + idCarro + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa
				+ ", valordiaria=" + valordiaria + "]";
	}
	
	
}

package com.provapdois.Aluguel.entities.pk;

import java.util.Objects;

import com.provapdois.Aluguel.entities.Carro;
import com.provapdois.Aluguel.entities.Cliente;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Embeddable
public class AluguelPK {
	private static final long serialVersionUID = 1L;
	@ManyToMany
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToMany
	@JoinColumn(name = "carro_id")
	private Carro carro;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carro, cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AluguelPK other = (AluguelPK) obj;
		return Objects.equals(carro, other.carro) && Objects.equals(cliente, other.cliente);
	}
	
	
	
}

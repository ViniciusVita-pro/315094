package com.provapdois.Aluguel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.provapdois.Aluguel.entities.Cliente;
import com.provapdois.Aluguel.repositories.ClienteRepository;
import com.provapdois.Aluguel.services.exceptions.DatabaseException;
import com.provapdois.Aluguel.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRep;

	public List<Cliente> findAll() {
		return clienteRep.findAll();
	}
	
	public Cliente findById(Long id) {
	Optional<Cliente> obj = clienteRep.findById(id);
	return obj.get();
	}
	
	public Cliente insert(Cliente obj) {
		return clienteRep.save(obj);
	}
	
	public void delete(Long id) {
		try {
			clienteRep.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Cliente update(Long id, Cliente obj) {
		try {
			Cliente entity = clienteRep.getReferenceById(id);
			updateData(entity, obj);
			return clienteRep.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setCelular(obj.getCelular());
		entity.setCnh(obj.getCnh());
	}
}

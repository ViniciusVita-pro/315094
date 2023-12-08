package com.provapdois.Aluguel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.provapdois.Aluguel.entities.Carro;
import com.provapdois.Aluguel.repositories.CarroRepository;
import com.provapdois.Aluguel.services.exceptions.DatabaseException;
import com.provapdois.Aluguel.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarroService {
	@Autowired
	private CarroRepository carroRep;

	public List<Carro> findAll() {
		return carroRep.findAll();
	}
	
	public Carro findById(Long id) {
	Optional<Carro> obj = carroRep.findById(id);
	return obj.get();
	}
	
	public Carro insert(Carro obj) {
		return carroRep.save(obj);
	}
	
	public void delete(Long id) {
		try {
			carroRep.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Carro update(Long id, Carro obj) {
		try {
			Carro entity = carroRep.getReferenceById(id);
			updateData(entity, obj);
			return carroRep.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Carro entity, Carro obj) {
		entity.setMarca(obj.getMarca());
		entity.setModelo(obj.getModelo());
		entity.setPlaca(obj.getPlaca());
		entity.setValordiaria(obj.getValordiaria());
	}
}

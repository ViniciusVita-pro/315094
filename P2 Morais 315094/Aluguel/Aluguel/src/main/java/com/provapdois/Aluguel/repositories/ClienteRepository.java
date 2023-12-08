package com.provapdois.Aluguel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.provapdois.Aluguel.entities.Cliente;

public interface  ClienteRepository extends JpaRepository<Cliente, Long>{

}

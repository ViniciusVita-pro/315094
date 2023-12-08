package com.provapdois.Aluguel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.provapdois.Aluguel.entities.Aluguel;
import com.provapdois.Aluguel.entities.pk.AluguelPK;

public interface AluguelRepository extends JpaRepository<Aluguel, AluguelPK> {

}

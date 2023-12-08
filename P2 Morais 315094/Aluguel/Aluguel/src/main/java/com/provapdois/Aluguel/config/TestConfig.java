package com.provapdois.Aluguel.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.provapdois.Aluguel.entities.Aluguel;
import com.provapdois.Aluguel.entities.Carro;
import com.provapdois.Aluguel.entities.Cliente;
import com.provapdois.Aluguel.repositories.AluguelRepository;
import com.provapdois.Aluguel.repositories.CarroRepository;
import com.provapdois.Aluguel.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private  ClienteRepository clienteRep;
	
	@Autowired
	private CarroRepository carroRep;
	
	@Autowired
	private AluguelRepository aluguelRepository; 
	
	public  void run(String... args) throws Exception{
		// TODO Auto-generated method stub
		Cliente cliente1 = new Cliente(null,"João Silva", "123.456.789-00", "(11) 98765-4321", "1234567890");
		Cliente cliente2 = new Cliente(null,"Maria Souza", "987.654.321-00", "(22) 99999-8888", "0987654321");
		Cliente cliente3 = new Cliente(null,"Carlos Oliveira", "111.222.333-44", "(33) 87654-1234", "5678901234");
		Cliente cliente4 = new Cliente(null,"Ana Santos", "555.666.777-88", "(44) 11111-2222", "9876543210");
		Cliente cliente5 = new Cliente(null,"Pedro Ferreira", "999.888.777-66", "(55) 33333-4444", "5432109876");
		clienteRep.saveAll(Arrays.asList(cliente1,cliente2,cliente3,cliente4,cliente5));

		Carro carro1 = new Carro(null, "Toyota", "Corolla", "ABC1234", (float) 150.0);
		Carro carro2 = new Carro(null, "Honda", "Civic", "DEF5678", (float) 170.0);
		Carro carro3 = new Carro(null, "Chevrolet", "Onix", "GHI9012", (float) 130.0);
		Carro carro4 = new Carro(null, "Ford", "Focus", "JKL3456", (float) 160.0);
		Carro carro5 = new Carro(null, "Volkswagen", "Gol", "MNO7890", (float) 140.0);
		carroRep.saveAll(Arrays.asList(carro1,carro2,carro3,carro4,carro5));

		Aluguel aluguel1 = new Aluguel(carro1,cliente1,  "12/07/2023","15/07/2023", (float) 130.5);
		Aluguel aluguel2 = new Aluguel(carro4,cliente2, "12/08/2023","15/08/2023", (float) 140.5);
		Aluguel aluguel3 = new Aluguel(carro3, cliente5, "12/09/2023","15/09/2023",(float) 150);
		aluguelRepository.saveAll(Arrays.asList(aluguel1, aluguel2,aluguel3));


	}

	

}

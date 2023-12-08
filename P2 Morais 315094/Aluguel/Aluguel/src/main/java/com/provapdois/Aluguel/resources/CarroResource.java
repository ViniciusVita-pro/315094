package com.provapdois.Aluguel.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.provapdois.Aluguel.entities.Carro;
import com.provapdois.Aluguel.services.CarroService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/carros")
public class CarroResource {
	// depois que criar o Service eu adiciona aqui esse obj carroServ
		@Autowired
		private CarroService carroServ;

		@CrossOrigin(origins = "*")
		@GetMapping
		public ResponseEntity<List<Carro>> findAll() {
			// preciso desse carro abaixo antes de criar o Service
			// Carro carro = new Carro(1L,"Maria", "maria@gmail", "9999999", "112233");

			// depois qur criar o Service eu nao preciso mais do carro acima
			// mas preciso da LIST abaixo
			List<Carro> list = carroServ.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Carro> findById(@PathVariable Long id){
			Carro obj = carroServ.findById(id);
			return ResponseEntity.ok().body(obj);
		}
		
		@PostMapping
		public ResponseEntity<Carro> insert(@RequestBody Carro obj) {
			obj = carroServ.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(obj.getIdCarro()).toUri();
			return ResponseEntity.created(uri).body(obj);
		}
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			carroServ.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		@PutMapping(value = "/{id}")
		public ResponseEntity<Carro> update(@PathVariable Long id, @RequestBody Carro obj) {
			obj = carroServ.update(id, obj);
			return ResponseEntity.ok().body(obj);
		}
}

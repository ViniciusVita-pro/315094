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

import com.provapdois.Aluguel.entities.Cliente;
import com.provapdois.Aluguel.services.ClienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/clientes")
public class ClienteResource {
	// depois que criar o Service eu adiciona aqui esse obj clienteServ
	@Autowired
	private ClienteService clienteServ;

	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		// preciso desse cliente abaixo antes de criar o Service
		// Cliente cliente = new Cliente(1L,"Maria", "maria@gmail", "9999999", "112233");

		// depois qur criar o Service eu nao preciso mais do cliente acima
		// mas preciso da LIST abaixo
		List<Cliente> list = clienteServ.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		Cliente obj = clienteServ.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente obj) {
		obj = clienteServ.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdCliente()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clienteServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente obj) {
		obj = clienteServ.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}

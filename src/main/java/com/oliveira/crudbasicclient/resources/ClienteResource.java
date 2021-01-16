package com.oliveira.crudbasicclient.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oliveira.crudbasicclient.dto.ClientDTO;
import com.oliveira.crudbasicclient.services.ClienteService;

@RestController
@RequestMapping(value = "/clients")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAll(	@RequestParam(value = "page", defaultValue = "0") Integer page,
													@RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
													@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
													@RequestParam(value = "direction", defaultValue = "ASC") String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<ClientDTO> list = service.findAll(pageRequest);
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
		ClientDTO list = service.findById(id);
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/findAllList")
	public ResponseEntity<List<ClientDTO>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();	
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO obj){
		obj = service.update(id,obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

package com.oliveira.crudbasicclient.services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oliveira.crudbasicclient.dto.ClientDTO;
import com.oliveira.crudbasicclient.entities.Client;
import com.oliveira.crudbasicclient.repositories.ClientRepository;
import com.oliveira.crudbasicclient.services.exceptions.DataBaseException;
import com.oliveira.crudbasicclient.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired	
	private ClientRepository repository;
	
	@Transactional(readOnly=true)
	public Page<ClientDTO> findAll(PageRequest page){
		return repository.findAll(page).map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly=true)
	public List<ClientDTO> findAll(){
		return repository.findAll().stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity =  obj.orElseThrow(() -> new ResourceNotFoundException("Client not found!"));
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client(dto);
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ClientDTO(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Client not found. ID: "+id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Client not found. ID: "+id);
		}catch( DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation. Msg: "+e.getMessage());
		}
	}
	
	private void copyDtoToEntity(ClientDTO dto, Client entity) {
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setName(dto.getName());
	}
}

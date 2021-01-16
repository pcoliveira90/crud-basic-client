package com.oliveira.crudbasicclient.dto;

import java.io.Serializable;
import java.time.Instant;

import com.oliveira.crudbasicclient.entities.Client;

public class ClientDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private Instant birthDate;
	private Integer children;
	
	
	public ClientDTO() {
		super();
	}
	public ClientDTO(Long id, String name, String cpf, Double income, Instant birthDate, Integer children) {
		super();
		setId(id);
		setName(name);
		setCpf(cpf);
		setIncome(income);
		setBirthDate(birthDate);
		setChildren(children);
	}
	
	public ClientDTO(Client entity) {
		super();
		setId(entity.getId());
		setName(entity.getName());
		setCpf(entity.getCpf());
		setIncome(entity.getIncome());
		setBirthDate(entity.getBirthDate());
		setChildren(entity.getChildren());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public Instant getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}
	public Integer getChildren() {
		return children;
	}
	public void setChildren(Integer children) {
		this.children = children;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientDTO other = (ClientDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}

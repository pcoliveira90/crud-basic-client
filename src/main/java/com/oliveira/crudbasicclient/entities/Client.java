package com.oliveira.crudbasicclient.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.oliveira.crudbasicclient.dto.ClientDTO;

@Entity
@Table(name ="tb_client")
public class Client  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	private Double income;
	@Column(columnDefinition =  "TIMESTAMP WITHOUT TIME ZONE")
	private Instant birthDate;
	private Integer children;
	
	@Column(columnDefinition =  "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createAt;
	
	@Column(columnDefinition =  "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updateAt;
	
	public Client() {
		super();
	}
	
	
	public Client(Long id, String name, String cpf, Double income, Instant birthDate, Integer children) {
		super();
		setId(id);
		setName(name);
		setCpf(cpf);
		setIncome(income);
		setBirthDate(birthDate);
		setChildren(children);
	}
	
	public Client(ClientDTO dto) {
		setName(dto.getName());
		setCpf(dto.getCpf());
		setIncome(dto.getIncome());
		setBirthDate(dto.getBirthDate());
		setChildren(dto.getChildren());
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
	
	public Instant getCreateAt() {
		return createAt;
	}
	
	@PrePersist
	private void prePersist() {
		this.createAt = Instant.now();
	}

	public Instant getUpdateAt() {
		return updateAt;
	}

	@PreUpdate
	private void preUpdate() {
		this.updateAt = Instant.now();
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

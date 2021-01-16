package com.oliveira.crudbasicclient.repositories;

import org.springframework.stereotype.Repository;

import com.oliveira.crudbasicclient.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}

package com.client.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.entity.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {

}


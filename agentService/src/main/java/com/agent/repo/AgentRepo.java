package com.agent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agent.entity.Agent;
@Repository
public interface AgentRepo extends JpaRepository<Agent, Integer> {

}
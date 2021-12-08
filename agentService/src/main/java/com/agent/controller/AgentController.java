package com.agent.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.agent.entity.Agent;
import com.agent.exception.ResourceNotFoundException;
import com.agent.repo.AgentRepo;

@RestController
@RequestMapping("/agentApi")
public class AgentController {
	@Autowired
	AgentRepo agentRepo;

	@Value("${client.details}")
	private String CLIENT_DETAILS;
	
	@Value("${transaction.details}")
	private String TRANSACTION_DETAILS;

	@GetMapping("/allAgents")
	public List<Agent> getAllAgents() {
		return agentRepo.findAll();
	}

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/agents/{id}")
	public ResponseEntity<Agent> getAgentById(@PathVariable(value = "id") int agentId)
			throws ResourceNotFoundException {
		Agent agent = agentRepo.findById(agentId)
				.orElseThrow(() -> new ResourceNotFoundException("Agent not found for this id :: " + agentId));
		List clients = this.restTemplate.getForObject(CLIENT_DETAILS + agent.getAgentid(), List.class);
		agent.setClients(clients);
		List transactions = this.restTemplate.getForObject(TRANSACTION_DETAILS + agent.getAgentid(), List.class);
		agent.setTransactions(transactions);
		return ResponseEntity.ok().body(agent);
	}

	@PostMapping("/agentRegistration")
	public ResponseEntity<String> createAgent(@Valid @RequestBody Agent agent) throws ResourceNotFoundException {
		agentRepo.save(agent);

		return new ResponseEntity<String>("Post succesfully", HttpStatus.OK);

	}

	@PutMapping("/agents/{id}")
	public ResponseEntity<Agent> updateAgent(@PathVariable(value = "id") int AgentId,
			@Valid @RequestBody Agent AgentDetails) throws ResourceNotFoundException {
		Agent Agent = agentRepo.findById(AgentId)
				.orElseThrow(() -> new ResourceNotFoundException("Agent not found for this id :: " + AgentId));

		Agent.setAgentName(AgentDetails.getAgentName());
		Agent.setAgentState(AgentDetails.getAgentState());
		Agent.setLinkedBankAccountName(AgentDetails.getLinkedBankAccountName());
		final Agent updatedAgent = agentRepo.save(Agent);
		return ResponseEntity.ok(updatedAgent);
	}

	@DeleteMapping("/agents/{id}")
	public Map<String, Boolean> deleteAgent(@PathVariable(value = "id") int AgentId) throws ResourceNotFoundException {
		Agent Agent = agentRepo.findById(AgentId)
				.orElseThrow(() -> new ResourceNotFoundException("Agent not found for this id :: " + AgentId));

		agentRepo.delete(Agent);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PutMapping("/fundTransfer/{id}/{amount}/{transactionType}")
	public ResponseEntity<Agent> updateAgentBallance(@PathVariable(value = "id") int AgentId,
			@PathVariable(value = "amount") int fundAmount,@PathVariable(value = "transactionType") String transactionType) throws ResourceNotFoundException {
		Agent Agent = agentRepo.findById(AgentId)
				.orElseThrow(() -> new ResourceNotFoundException("Agent not found for this id :: " + AgentId));

		if(transactionType.equals("AtoC"))
		{
			Agent.setWalletBalance(Agent.getWalletBalance() - fundAmount);
		}
		else
		{
			Agent.setWalletBalance(Agent.getWalletBalance() + fundAmount);
		}
		
		final Agent updatedAgent = agentRepo.save(Agent);
		return ResponseEntity.ok(updatedAgent);
	}

}
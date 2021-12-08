package com.transaction.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transaction.entity.OTP;
import com.transaction.entity.Transaction;
import com.transaction.exception.ResourceNotFoundException;
import com.transaction.repo.TransactionRepo;

@RestController
@RequestMapping("/transactionApi")
public class TransactionController {
	@Autowired
	TransactionRepo transactionRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${otp.gen}")
	private String OTPGEN;
	
	@Value("${otp.ver}")
	private String OTPVER;

	@Value("${agent.transfer}")
	private String AGENT_FUND_TRANSFER;
	
	@Value("${client.transfer}")
	private String CLIENT_FUND_TRANSFER;

	@GetMapping("/allTransactions")
	public List<Transaction> getAllTransactions() {
		return transactionRepo.findAll();
	}

	@GetMapping("/transaction/{id}")
	public ResponseEntity<Transaction> gettransactionById(@PathVariable(value = "id") int transactionId)
			throws ResourceNotFoundException {
		Transaction transaction = transactionRepo.findById(transactionId).orElseThrow(
				() -> new ResourceNotFoundException("transaction not found for this id :: " + transactionId));
		return ResponseEntity.ok().body(transaction);
	}

	@GetMapping("/agent/{id}")
	public List<Transaction> getAgentById(@PathVariable(value = "id") int agentId) {
		List<Transaction> list = transactionRepo.findAll();
		return list.stream().filter(agent -> agent.getAgentId() == agentId).collect(Collectors.toList());
	}

	@GetMapping("/client/{id}")
	public List<Transaction> getClientsById(@PathVariable(value = "id") int clientId) {
		List<Transaction> list = transactionRepo.findAll();
		return list.stream().filter(client -> client.getAgentId() == clientId).collect(Collectors.toList());
	}

	@PostMapping("/fundTransactionSend")
	public ResponseEntity<String> initiate(@RequestBody OTP otp) throws ResourceNotFoundException {
		// transactionRepo.save(transaction);

		String url = OTPGEN;

		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = Obj.writeValueAsString(otp);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String requestJson = jsonStr;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		String answer = restTemplate.postForObject(url, entity, String.class);
		System.out.println(answer);

		return new ResponseEntity<String>(answer, HttpStatus.OK);

	}

	@PostMapping("/fundTransaction/{transferamount}/{agentId}/{clientId}/{transactionType}")
	public ResponseEntity<String> createtransaction(@PathVariable(value = "transferamount") int transferamount,
			@PathVariable(value = "agentId") int agentId, @PathVariable(value = "clientId") int clientId,
			@PathVariable(value = "transactionType") String transactionType, @Valid @RequestBody OTP otp)
			throws ResourceNotFoundException {

		Transaction transaction = new Transaction();
		transaction.setTransferamount(transferamount);
		transaction.setAgentId(agentId);
		transaction.setClientId(clientId);
		transaction.setTransactionType(transactionType);
		transactionRepo.save(transaction);

		String url = OTPVER;

		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = Obj.writeValueAsString(otp);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String requestJson = jsonStr;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		String answer = restTemplate.postForObject(url, entity, String.class);

		if (answer.equals("OTP verified successfully")) {

			this.restTemplate.put(AGENT_FUND_TRANSFER + transaction.getAgentId() + "/" + transaction.getTransferamount()
					+ "/" + transaction.getTransactionType(), Transaction.class);
			this.restTemplate.put(CLIENT_FUND_TRANSFER + transaction.getClientId() + "/"
					+ transaction.getTransferamount() + "/" + transaction.getTransactionType(), Transaction.class);

			return new ResponseEntity<String>("FUND Transfered..", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(answer, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
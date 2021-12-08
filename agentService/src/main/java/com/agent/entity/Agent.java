package com.agent.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Agent {
	
	@Id
	private int agentid;
	private String agentName;
	private String agentState;
	private String linkedBankAccountName;
	private int walletBalance;
	@Column
    @ElementCollection(targetClass=Integer.class)
	List<Client> clients=new ArrayList<>();
	@Column
    @ElementCollection(targetClass=Integer.class)
	List<Transaction> transactions=new ArrayList<>();
	public int getAgentid() {
		return agentid;
	}
	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentState() {
		return agentState;
	}
	public void setAgentState(String agentState) {
		this.agentState = agentState;
	}
	public String getLinkedBankAccountName() {
		return linkedBankAccountName;
	}
	public void setLinkedBankAccountName(String linkedBankAccountName) {
		this.linkedBankAccountName = linkedBankAccountName;
	}
	public int getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(int walletBalance) {
		this.walletBalance = walletBalance;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	
	
}

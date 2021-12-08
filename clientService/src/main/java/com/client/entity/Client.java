package com.client.entity;

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
public class Client {
		
		@Id
		private int clientid;
		private String clientName;
		private String clientState;
		private String bankAccountName;
		private int walletBalance;
		private int agentId;
		public int getClientid() {
			return clientid;
		}
		public void setClientid(int clientid) {
			this.clientid = clientid;
		}
		public String getClientName() {
			return clientName;
		}
		public void setClientName(String clientName) {
			this.clientName = clientName;
		}
		public String getClientState() {
			return clientState;
		}
		public void setClientState(String clientState) {
			this.clientState = clientState;
		}
		public String getBankAccountName() {
			return bankAccountName;
		}
		public void setBankAccountName(String bankAccountName) {
			this.bankAccountName = bankAccountName;
		}
		public int getWalletBalance() {
			return walletBalance;
		}
		public void setWalletBalance(int walletBalance) {
			this.walletBalance = walletBalance;
		}
		public int getAgentId() {
			return agentId;
		}
		public void setAgentId(int agentId) {
			this.agentId = agentId;
		}
		
		

}


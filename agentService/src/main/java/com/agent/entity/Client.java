package com.agent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

		private int clientid;
		private String clientName;
		private String clientState;
		private String bankAccountName;
		private int walletBalance;
}


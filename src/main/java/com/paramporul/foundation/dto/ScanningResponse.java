package com.paramporul.foundation.dto;

import org.springframework.stereotype.Component;

@Component
public class ScanningResponse {

	private int totalTickets;
	private String  status;

	public int getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(int totalTickets) {
		this.totalTickets = totalTickets;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

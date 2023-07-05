package com.paramporul.foundation.dto;

import org.springframework.stereotype.Component;

@Component
public class BookingResponse {
	private int totalSeats;
	private int availableSeats;
	private int holdingSeats;
	private String bookingStatus;

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getHoldingSeats() {
		return holdingSeats;
	}

	public void setHoldingSeats(int holdingSeats) {
		this.holdingSeats = holdingSeats;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
}

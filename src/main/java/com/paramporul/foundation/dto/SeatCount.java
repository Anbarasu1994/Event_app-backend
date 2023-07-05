package com.paramporul.foundation.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SeatCount {
	private String uuid;
	private int seatCount;
	private int eventId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
}

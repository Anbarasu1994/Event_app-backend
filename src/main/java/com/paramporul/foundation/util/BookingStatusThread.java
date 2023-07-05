package com.paramporul.foundation.util;

import org.springframework.stereotype.Service;

import com.paramporul.foundation.dto.SeatCount;
import com.paramporul.foundation.model.Booking;
import com.paramporul.foundation.model.Events;
import com.paramporul.foundation.repository.BookingRepository;
import com.paramporul.foundation.repository.EventsRepository;

@Service
public class BookingStatusThread implements Runnable {
	private EventsRepository eventsRepository;
	private BookingRepository bookingRepository;
	private final SeatCount seatCount;
	public BookingStatusThread(SeatCount seatCount,BookingRepository bookingRepository, EventsRepository eventsRepository ) {
		this.seatCount = seatCount;
		this.bookingRepository =bookingRepository;
		this.eventsRepository = eventsRepository;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(300000);
			Booking booking = bookingRepository.findByUuidAndEventId(seatCount.getUuid(), seatCount.getEventId());
			if (booking == null) {
				Events eventObject = eventsRepository.getByEventId(seatCount.getEventId());
				eventObject.setAvailableSeats(eventObject.getAvailableSeats() + seatCount.getSeatCount());
				eventsRepository.save(eventObject);
			}
		} catch (InterruptedException ex) {
			System.out.println("BookingStatusThread was interrupted");
		}
	}

}

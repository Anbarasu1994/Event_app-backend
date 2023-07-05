package com.paramporul.foundation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paramporul.foundation.dto.BookingHistoryResponse;
import com.paramporul.foundation.model.Booking;
import com.paramporul.foundation.model.Events;
import com.paramporul.foundation.repository.BookingRepository;
import com.paramporul.foundation.repository.EventsRepository;

@Service
public class BookingHistoryService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private EventsRepository eventsRepository;


	public List<BookingHistoryResponse> getBookingHistoryByUuid(String uuid) {
		List<Booking> bookings = bookingRepository.findByUuid(uuid);
	 	List<BookingHistoryResponse> bookingHistoryResponse = new ArrayList<BookingHistoryResponse>();
			for (Booking booking : bookings) {
				BookingHistoryResponse bookinghistoryObj = new BookingHistoryResponse();
				bookinghistoryObj.setQuantity(booking.getQuantity());
				bookinghistoryObj.setTicketPrice(booking.getTicketPrice());
				Events event = eventsRepository.getByEventId(booking.getEventId());
				bookinghistoryObj.setEventName(event.getEventName());
				bookinghistoryObj.setEventId(event.getEventId());
				bookinghistoryObj.setStartDate(event.getStartDate());
				bookinghistoryObj.setDuration(event.getDuration());
				bookinghistoryObj.setPlace(event.getPlace());
				bookinghistoryObj.setThumbnail(event.getThumbnail());
				bookingHistoryResponse.add(bookinghistoryObj);
			}
		return bookingHistoryResponse;
	}
}

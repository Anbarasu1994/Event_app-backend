package com.paramporul.foundation.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.paramporul.foundation.dto.ScanningResponse;
import com.paramporul.foundation.util.BookingStatusThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.paramporul.foundation.dto.BookingResponse;
import com.paramporul.foundation.dto.SeatCount;
import com.paramporul.foundation.model.Booking;
import com.paramporul.foundation.model.Events;
import com.paramporul.foundation.repository.BookingRepository;
import com.paramporul.foundation.repository.EventsRepository;
@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private EventsRepository eventsRepository;
	public Booking addBooking(Booking booking) {
		Random random = new Random();
		int ticketIdIn = 100000 + random.nextInt(900000);
		String ticketId1 = ("PF" + Integer.toString(ticketIdIn));
		booking.setTicketId(ticketId1);
		booking.setStatus("Success");

		Booking saveBooking = bookingRepository.save(booking);
		return booking;
	}

	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}

	public String deleteByBookingId(Integer bookingId) {
		bookingRepository.deleteById(bookingId);
		return "Booking deleted Successfully";
	}

	public Booking updateBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	public ScanningResponse updateBookingByTicketId(Booking booking) {
		Booking bookingObj = bookingRepository.findByTicketId(booking.getTicketId());
		ScanningResponse res = new ScanningResponse();
		if(bookingObj.isCheckInStatus()){
			res.setTotalTickets(bookingObj.getQuantity());
			res.setStatus("Already Scanned");

		}else {
			bookingObj.setCheckInStatus(true);
			res.setTotalTickets(bookingObj.getQuantity());
			res.setStatus("Scanned Successfully");
		}
		bookingRepository.save(bookingObj);
		return res;
	}

	public List<Booking> getBookingByUuid(String uuid) {
		return  bookingRepository.findByUuid(uuid);
	}
	public Booking getBookingByBookingId(int bookingId){
		return bookingRepository.findByBookingId(bookingId);
	}

	public BookingResponse bookSeats(SeatCount seat) {
		Events eventObject = eventsRepository.getByEventId(seat.getEventId());
		eventObject.setAvailableSeats(eventObject.getAvailableSeats() - seat.getSeatCount());
		eventsRepository.save(eventObject);
		Thread thread = new Thread(new BookingStatusThread(seat, bookingRepository, eventsRepository));
		thread.start();
		BookingResponse response = new BookingResponse();
		response.setBookingStatus("Holding");
		return response;
	}
	public List<Events> getUpcomingEvents() throws ParseException {
		List<Events> upcomingEvents = new ArrayList<>();
		LocalDate today = LocalDate.now();
		List<Events> events = eventsRepository.findAll();
			for (Events event : events) {
				String  dateString = String.valueOf(event.getStartDate());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate date = LocalDate.parse(dateString, formatter);
				if (date.isAfter(today)) {
					upcomingEvents.add(event);
				}
			}
		upcomingEvents.sort(Comparator.comparing(Events::getStartDate));
		return upcomingEvents;
	}
}

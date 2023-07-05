package com.paramporul.foundation.controller;
import java.text.ParseException;
import java.util.List;

import com.paramporul.foundation.dto.ScanningResponse;
import com.paramporul.foundation.model.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paramporul.foundation.dto.BookingResponse;
import com.paramporul.foundation.dto.SeatCount;
import com.paramporul.foundation.model.Booking;
import com.paramporul.foundation.service.BookingService;
import com.paramporul.foundation.service.EventsService;

@RestController
@RequestMapping("/Booking")
@CrossOrigin
public class BookingController {
	@Autowired
	private BookingService bookingService;
	@Autowired
	private EventsService eventsService;

	@PostMapping("/addBooking")
	public Booking addBooking(@RequestBody Booking booking) {
		return bookingService.addBooking(booking);

	}

	@PutMapping("/updateBooking")
	public Booking updateBooking(@RequestBody Booking booking) {
		return bookingService.updateBooking(booking);
	}

	@PutMapping("/updateBookingByTicketId")
	public ScanningResponse updateBookingByTicketId(@RequestBody Booking booking) {
		return bookingService.updateBookingByTicketId(booking);
	}

	@GetMapping("/getAllBooking")
	public List<Booking> getAllBooking() {
		return bookingService.getAllBooking();
	}

	@DeleteMapping("/deleteBooking/{bookingId}")
	public String deleteByBookingId(@PathVariable int bookingId) {
		return bookingService.deleteByBookingId(bookingId);
	}

		@GetMapping("/getBookingByUuid/{uuid}")
	public List <Booking> getBooking(@PathVariable String uuid) {
		return bookingService.getBookingByUuid(uuid);
	}
	@GetMapping("/getBookingByBookingId/{bookingId}")
	public Booking getBooking(@PathVariable int bookingId){
		return bookingService.getBookingByBookingId(bookingId);
	}

	@PostMapping("/bookSeats")
	public BookingResponse bookSeats(@RequestBody SeatCount seat) {
		BookingResponse response = bookingService.bookSeats(seat);
		return response;
	}
	@GetMapping("/upcomingEvents")
	public List<Events> getUpcomingEvents() throws ParseException {
		return bookingService.getUpcomingEvents();
	}

}

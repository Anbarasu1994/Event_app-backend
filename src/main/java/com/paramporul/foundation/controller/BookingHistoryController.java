package com.paramporul.foundation.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.paramporul.foundation.service.BookingHistoryService;

import java.util.List;

@RestController
@RequestMapping("/BookingHistory")
@CrossOrigin
public class BookingHistoryController {
	@Autowired
	private BookingHistoryService bookingHistoryService;
	@GetMapping("/getDetails/{uuid}")
	public List getBooking(@PathVariable String uuid) {

		return bookingHistoryService.getBookingHistoryByUuid(uuid);
	}
}
	
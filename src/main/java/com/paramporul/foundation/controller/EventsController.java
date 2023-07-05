package com.paramporul.foundation.controller;

import java.util.List;
import java.util.Optional;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.paramporul.foundation.model.Note;
import com.paramporul.foundation.repository.EventsRepository;
import com.paramporul.foundation.service.FirebaseMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.paramporul.foundation.model.Events;
import com.paramporul.foundation.service.EventsService;

/*
 * @author sethuvekram
 *  @date 28/02/2023
 */
@RestController
@RequestMapping("/events")
@CrossOrigin
public class EventsController {
	@Autowired
	private EventsService eventsService;
	@Autowired
	private FirebaseMessagingService firebaseService;
	@Autowired
	private EventsRepository eventsRepository;

	@PostMapping("/addEvent")
	public Events addEvent(@RequestBody Events events) {
		return eventsService.addEvents(events);
	}

	@GetMapping("/getAllEvents")
	public List<Events> getAllEvents() {
		return eventsService.getAllEvents();
	}

	@PutMapping("/updateEvent")
	public Events updateEvent(@RequestBody Events events) {
		return eventsService.updateEvents(events);
	}

	@DeleteMapping("/deleteEvent/{eventId}")
	public String deleteById(@PathVariable int eventId) {
		eventsService.deleteByEventId(eventId);
		return "Event Deleted";
	}

	@GetMapping("/getEventById/{eventId}")
	public Optional<Events> getEventById(@PathVariable int eventId) {
		return eventsService.getEventsByEventId(eventId);
	}
	@RequestMapping("/sendnotification")
	@ResponseBody
	public String sendNotification(@RequestBody Note note, @RequestParam String token)
			throws FirebaseMessagingException {
		return firebaseService.sendNotification(note, token);
	}


}

package com.paramporul.foundation.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.paramporul.foundation.model.Events;
import com.paramporul.foundation.repository.EventsRepository;

@Service
public class EventsService {
	@Autowired
	private EventsRepository eventRepo;

	public Events addEvents(Events events) {
		return eventRepo.save(events);
	}

//	public List<Events> getAllEvents() {
//
//		List<Events> events = eventRepo.findAll(Sort.by(Sort.Direction.DESC, "startDate"));
//
//		LocalDate today = LocalDate.now();
//
//		for (Events event : events) {
//			try {
//				LocalDate eventDate = LocalDate.parse(event.getStartDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//				if (eventDate.isBefore(today)) {
//					event.setEventStatus("FINISHED");
//				} else {
//					event.setEventStatus("UPCOMING");
//				}
//			} catch (DateTimeParseException e) {
//
//			}
//		}
//
//		eventRepo.saveAll(events);
//
//		return events;
//	}

	public List<Events> getAllEvents() {
		List<Events> events = eventRepo.findAll(Sort.by(Sort.Direction.ASC, "startDate"));

		LocalDate today = LocalDate.now();

		for (Events event : events) {
			try {
				LocalDate eventDate = LocalDate.parse(event.getStartDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				if (eventDate.isBefore(today)) {
					event.setEventStatus("FINISHED");
				} else {
					event.setEventStatus("UPCOMING");
				}

				LocalTime startTime = LocalTime.parse(event.getStartTime(), DateTimeFormatter.ofPattern("HH:mm"));
				String formattedStartTime = startTime.format(DateTimeFormatter.ofPattern("hh:mm a"));

				LocalDateTime eventDateTime = LocalDateTime.of(eventDate, startTime);
				event.setStartDate(eventDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				event.setStartTime(formattedStartTime);

			} catch (DateTimeParseException e) {
				// Handle exception if parsing the event's start date or start time fails
			}
		}

		eventRepo.saveAll(events);

		return events;
	}






	public Events updateEvents(Events events) {
		return eventRepo.save(events);
	}

	public String deleteByEventId(int eventId) {
		eventRepo.deleteById(eventId);
		return "event deleted Successfully";
	}

	public Optional<Events> getEventsByEventId(int eventId) {
		return eventRepo.findById(eventId);
	}


}

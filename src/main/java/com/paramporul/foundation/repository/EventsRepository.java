package com.paramporul.foundation.repository;

import jdk.jfr.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.paramporul.foundation.model.Events;

import java.time.LocalDate;
import java.util.List;

/*
 * @author sethuvekram
 * @date 28/02/2023
 */
@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {
	Events getByEventId(int eventId);
}

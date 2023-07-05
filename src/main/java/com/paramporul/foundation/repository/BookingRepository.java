package com.paramporul.foundation.repository;

import com.paramporul.foundation.model.Booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	public Booking findByBookingId(Integer bookingId);

	void deleteById(Integer bookingId);



	List<Booking> findByUuid(String uuid);

	Booking findByStatus(String holding);

	Booking findByUuidAndEventId(String uuid, int eventId);


    Booking findByTicketId(String ticketId);
}

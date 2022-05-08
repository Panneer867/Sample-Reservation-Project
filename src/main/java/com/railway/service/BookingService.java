package com.railway.service;

import java.util.List;

import com.railway.model.Booking;

public interface BookingService {
	
	List<Booking> getAllBooking();
	void saveTicket(Booking booking);
	void cancelTicket(Long ticketNo);
	Booking getTicketById(long ticketNo);
	
}

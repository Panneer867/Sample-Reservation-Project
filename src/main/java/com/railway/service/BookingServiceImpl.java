package com.railway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.model.Booking;
import com.railway.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<Booking> getAllBooking() {
		
		return bookingRepository.findAll();
	}

	@Override
	public void saveTicket(Booking booking) {
		this.bookingRepository.save(booking);

	}

	@Override
	public void cancelTicket(Long ticketNo) {
		this.bookingRepository.deleteById(ticketNo);
		
	}

	@Override
	public Booking getTicketById(long ticketNo) {
		Optional < Booking > optional = bookingRepository.findById(ticketNo);
		Booking book = null;
		if(optional.isPresent()) {
			book = optional.get();
		} else {
			throw new RuntimeException("Ticket is not found for this ID ::" + ticketNo);
		}
		return book;
	}

}

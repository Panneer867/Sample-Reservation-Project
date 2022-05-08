package com.railway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.railway.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	

}

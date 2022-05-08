package com.railway.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.railway.model.Booking;
import com.railway.model.Train;
import com.railway.model.User;
import com.railway.repository.UserRepository;
import com.railway.service.BookingService;
import com.railway.service.TrainService;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private TrainService trainService;	
	
	@GetMapping("/ticketpage")
	public String ticketLists(Model model, Principal principal) {
		
		String name = principal.getName();
        User findByEmail = userRepository.findByEmail(name);
        model.addAttribute("firstName", findByEmail.getFirstName());
		
		model.addAttribute("listBookings", bookingService.getAllBooking());
		return "user/tickets_page";
	}
	
	
	
	@GetMapping("/cancelingticket-{ticketNo}")
	public String cancellingTicket(@PathVariable (value = "ticketNo") Long ticketNo) {
		this.bookingService.cancelTicket(ticketNo);
		return "redirect:/ticketpage";
		
	}
	
	@GetMapping("/available-trains")
    public String ticket(Model model, Principal principal) {
		
		
		
		String name = principal.getName();
	    User findByEmail = userRepository.findByEmail(name);
	    model.addAttribute("firstName", findByEmail.getFirstName());
	    
	    model.addAttribute("trainsavailable",trainService.getAllTrains());
        return "user/trains";
    }

	@GetMapping("/bookticket-{trainNo}")
    public String book(@PathVariable(value = "trainNo") long trainNo, Model model, Principal principal) {
		
		String name = principal.getName();
	    User findByEmail = userRepository.findByEmail(name);
	    model.addAttribute("firstName", findByEmail.getFirstName());
	    	    
	    model.addAttribute("booking", new Booking());
	    Train booking = trainService.getTrainById(trainNo);
		model.addAttribute("booking",booking);
		
		return "user/ticket_booking";
	}
	
	
	@PostMapping("/saveticket")
	public String saveBookings(@ModelAttribute("booking") Booking booking) {
		
		bookingService.saveTicket(booking);
		return "redirect:/ticketpage";
	}
	
	@GetMapping("/bookedticket-{ticketNo}")
    public String bookedticket(@PathVariable(value = "ticketNo") long ticketNo, Model model, Principal principal) {
		
		model.addAttribute("booking", new Booking());
		
	    Booking booked = bookingService.getTicketById(ticketNo);
		model.addAttribute("booked",booked);
		
        return "user/booked_ticket";
    }
}

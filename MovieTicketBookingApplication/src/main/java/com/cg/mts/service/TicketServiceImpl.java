package com.cg.mts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entity.Booking;
import com.cg.mts.entity.Ticket;
import com.cg.mts.exception.TicketNotFoundException;
import com.cg.mts.repository.BookingRepository;
import com.cg.mts.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public Ticket addTicket(Ticket ticket,Integer transactionId) throws TicketNotFoundException {
		Booking booking=new Booking();
		if(transactionId!=null) {
			booking=bookingRepository.findById(transactionId).get();
			booking.setTransactionStatus("Completed");
			ticket.setBooking(booking);
		}
		ticketRepository.saveAndFlush(ticket);
		
		return ticket;
	}

	@Override
	public List<Ticket> viewTicketList() throws TicketNotFoundException {
		List<Ticket> ti = ticketRepository.findAll();
		if (ti.size() == 0)
			throw new TicketNotFoundException("No tickets are avaliable");
		return ti;
	}

	@Override
	public Ticket findTicket(int ticketId) {

		return ticketRepository.findById(ticketId).get();
	}

}

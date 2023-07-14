package com.greatlearning.TicketManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.TicketManagement.model.TicketModel;
import com.greatlearning.TicketManagement.repository.TicketRepo;

@Service
public class TicketService {

	@Autowired
	TicketRepo ticketRepo;

	public List<TicketModel> getTicketsList() {
		return ticketRepo.findAll();
	}

	public TicketModel newTicket(TicketModel ticket) {
		return ticketRepo.save(ticket);
	}

	public void deleteTicket(int id) {
		ticketRepo.deleteById(id);

	}

	public TicketModel updateTicketById(int id, TicketModel ticket) {
		TicketModel ticketDb = ticketRepo.findById(id).get();
		ticketDb.setTicketTitle(ticket.getTicketTitle());
		ticketDb.setTicketDesc(ticket.getTicketDesc());
		ticketDb.setDate(ticket.getDate());
		return ticketRepo.save(ticketDb);
	}

	public TicketModel showTicketById(int id) {
		return ticketRepo.findById(id).get();
		
	}
}

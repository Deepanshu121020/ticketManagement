package com.greatlearning.TicketManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.greatlearning.TicketManagement.model.TicketModel;
import com.greatlearning.TicketManagement.service.TicketService;

@Controller
@RequestMapping("/admin")
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping("/lists")
	public List<TicketModel> getTicketsList() {
		return ticketService.getTicketsList();
	}

	@PostMapping("/newTicket")
	public TicketModel newTicket(@RequestParam("ticketId") int id, @RequestParam("ticketTitle") String ticketTitle,
			@RequestParam("ticket_description") String ticketDesc, @RequestParam("ticket_date") String date) {
		TicketModel ticket = new TicketModel();
		ticket.setTicketTitle(ticketTitle);
		ticket.setTicketDesc(ticketDesc);
		ticket.setDate(date);
		return ticketService.newTicket(ticket);
	}

	@DeleteMapping("/deleteTicket")
	public String deleteTicketById(@RequestParam("ticketId") int id) {
		ticketService.deleteTicket(id);
		return "ticket is deleted";
	}

	@PutMapping("/updateTicket")
	public TicketModel updateTicketById(@RequestParam("ticketId") int id, @RequestBody TicketModel ticket) {
		return ticketService.updateTicketById(id, ticket);

	}

	@GetMapping("/showTicketById")
	public TicketModel showTicketById(@RequestParam("ticketId") int id) {
		return ticketService.showTicketById(id);
	}

	@GetMapping("/list")
	public String getAllTickets(Model theModel) {
		List<TicketModel> listTickets = ticketService.getTicketsList();
		theModel.addAttribute("tickets", listTickets);
		return "ticket/list-ticket";
	}

	@PostMapping("/edit")
	public String showFormForUpdate(@RequestParam("TicketId") int id, Model theModel) {
		TicketModel ticketDb = ticketService.showTicketById(id);
		theModel.addAttribute("ticket", ticketDb);
		return "ticket/ticket-form";
	}

	@GetMapping("/new")
	public String showFormForAdd(Model theModel) {
		TicketModel ticket = new TicketModel();
		theModel.addAttribute("employees", ticket);
		return "ticket/ticket-form-new";
	}
	@PostMapping("/delete")
	public String deleteMyBook(@RequestParam("employeeId") int id)
	{
		ticketService.deleteTicket(id);
		return "redirect:/ticket/list-ticket";
	}

}
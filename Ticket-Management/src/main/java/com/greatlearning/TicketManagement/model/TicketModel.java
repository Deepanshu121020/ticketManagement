package com.greatlearning.TicketManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class TicketModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "#")
	private int id;
	@Column(name = "ticket_title")
	private String ticketTitle;
	@Column(name = "ticket_description")
	private String ticketDesc;
	@Column(name = "date")
	private String date;

	public TicketModel() {
	}

	public TicketModel(int id, String ticketTitle, String ticketDesc, String date) {
		super();
		this.id = id;
		this.ticketTitle = ticketTitle;
		this.ticketDesc = ticketDesc;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}

	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	public String getTicketDesc() {
		return ticketDesc;
	}

	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

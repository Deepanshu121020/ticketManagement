package com.greatlearning.TicketManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.TicketManagement.model.TicketModel;

@Repository
public interface TicketRepo extends JpaRepository<TicketModel, Integer> {

}

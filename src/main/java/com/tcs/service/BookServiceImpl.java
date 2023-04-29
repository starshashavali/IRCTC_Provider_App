package com.tcs.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tcs.request.Passenger;
import com.tcs.responce.Ticket;

@Service
public class BookServiceImpl implements BookingService {
	//to store data in HashMap without db
	private Map<Integer, Ticket> ticketMap = new HashMap<>();
	//every  time ticket num will increase
	private Integer ticketNum = 1;

	@Override

	public Ticket bookTicket(Passenger passenger) {
		//passing passenger data as a input  to Ticket Obj
		Ticket t = new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketCost(550.00);
		t.setStatus("CONFIRMED");
		t.setTicketNum(ticketNum);
		ticketMap.put(ticketNum, t);
		ticketNum++;

		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		//passing passenger data as a input  getting ticket as output
		if (ticketMap.containsKey(ticketNumber)) {
			//if ticket no is there then get details
		}
		return ticketMap.get(ticketNumber);

	}

}

package com.tcs.service;

import com.tcs.request.Passenger;
import com.tcs.responce.Ticket;

public interface BookingService {
	public Ticket bookTicket(Passenger passenger);

	public Ticket getTicket(Integer ticketNumber);

}
/*
 * 
 * 
 * url post   localhost:9098/ticket
   {
       "name":"Ram",
"from":"HYD",
"to":"Vizag",
"doj":"23/06/1997",
"trainNumber":"123456"

}
 */

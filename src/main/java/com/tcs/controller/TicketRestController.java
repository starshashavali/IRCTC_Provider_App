package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.request.Passenger;
import com.tcs.responce.Ticket;
import com.tcs.service.BookingService;



@RestController
public class TicketRestController {
	@Autowired
	private BookingService bookingService;
/*
 * 
consumes : It represents in which format REST API method can accept input data from client

produces : It represents in which format REST API method can provide response to clients


Content-Type : This header will represent in which format client sending data to server in request body

Accept : This header will represent in which format client expecting response from server

 */
	// method to book the ticket
	@PostMapping(value = "/ticket", consumes = { "application/json" }, produces = { "application/json" })

	// this method taking Passenger data input and gives ticket output

	public ResponseEntity<Ticket> ticketBooking(@RequestBody Passenger passenger) {
		Ticket ticket = bookingService.bookTicket(passenger);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);

	}

	@GetMapping(value = "/ticket/{ticketNum}", produces = "application/json")

	// method o gret the ticket
	public Ticket getTicketByNum(@PathVariable Integer ticketNum) {
		return bookingService.getTicket(ticketNum);

	}
	
}

/*
 * 
 * 
 * 
@RestController : To represent java class as Distributed Component

		@RestController = @Controller + @ResponseBody

@GetMapping : Map the method to HTTP GET Request

@PostMapping : Map the method to HTTP POST Request

@RequestBody : To read payload from HTTP Request Body

ResponseEntity : To set custom HTTP Status Code in Response

Postman : To test REST API functionality
----------------
Path Parameters
----------------

-> To send data to server in the URL

-> Path Param will represent data directley

-> Path Params can present anywhere in the URL

-> Path Param will start with '/' and will be seperated by '/'

-> We need to represent Path Parameters position in the URL pattern like below

			Ex:  @GetMapping("/user/{id}/data")

-> To read Path Parameters we will use @PathVariable annotation
*/



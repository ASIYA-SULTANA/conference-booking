package org.accion.controller;

import java.time.LocalDate;
import java.util.List;

import org.accion.entity.Bookings;
import org.accion.service.IBookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequestMapping("bookings")
@CrossOrigin(origins = {"http://localhost:4200"})
public class BookingsController {
	@Autowired
	private IBookingsService bookingService;
	@GetMapping("getBookingsByBookingId")
	public ResponseEntity<Bookings> getBookingsByBookingId(@RequestParam("bookingId") String bookingId){
	Bookings booking=bookingService.getBookingsByBookingId(Integer.parseInt(bookingId));
	return new ResponseEntity<Bookings>(booking, HttpStatus.OK);
	}
	
	@GetMapping("allBookings")
	public ResponseEntity<List<Bookings>> getAllBookings(){
		List<Bookings> booking = bookingService.getAllBookings();
		return new ResponseEntity<List<Bookings>>(booking,HttpStatus.OK);
	}
	
	@PostMapping("createBookings")
	public ResponseEntity<Void> createBookings(@RequestBody Bookings booking, UriComponentsBuilder builder){
		bookingService.createBookings(booking);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/createBookings?bookings={bookings}").buildAndExpand(booking.getUserName()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("deleteBookings")
	public ResponseEntity<Void> deleteUser(@RequestParam("bookingId") String bookingId) {
		bookingService.deleteBookings(Integer.parseInt(bookingId));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping("allBookingsByRoomNameAndDate")
	public ResponseEntity<List<Bookings>> getAllBookingsByRoomNameAndDate(@RequestParam("roomName") String roomName, @RequestParam("date") LocalDate date){
		List<Bookings> booking = bookingService.getBookingsByRoomNameAndDate(roomName, date);
		return new ResponseEntity<List<Bookings>>(booking,HttpStatus.OK);
	}
	
}

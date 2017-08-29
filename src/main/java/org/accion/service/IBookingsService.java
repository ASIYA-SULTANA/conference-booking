package org.accion.service;

import java.time.LocalDate;
import java.util.List;
import org.accion.entity.Bookings;


public interface IBookingsService {
	List<Bookings> getAllBookings();
	Bookings getBookingsByBookingId(int bookingId);
	void createBookings(Bookings booking);
	void deleteBookings(int bookingId);
	List<Bookings> getBookingsByRoomNameAndDate(String roomName, LocalDate date);
}

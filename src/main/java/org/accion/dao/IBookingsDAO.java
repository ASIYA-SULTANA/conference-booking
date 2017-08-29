package org.accion.dao;

import java.time.LocalDate;
import java.util.List;

import org.accion.entity.Bookings;

public interface IBookingsDAO {
	 List<Bookings> getAllBookings();
	    Bookings getBookingsByBookingId(int bookingId);
	    void createBookings(Bookings booking);
	 // void updateBookings(Bookings booking);
	    void deleteBookings(int bookingId);
	    List<Bookings> getBookingsByRoomNameAndDate(String roomName,LocalDate date);
}

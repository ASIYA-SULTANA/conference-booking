package org.accion.service;

import java.time.LocalDate;
import java.util.List;

import org.accion.dao.IBookingsDAO;
import org.accion.entity.Bookings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingsService implements IBookingsService {
	@Autowired
	private IBookingsDAO bookingsDAO;

	@Override
	public List<Bookings> getAllBookings() {
		return bookingsDAO.getAllBookings();
	}

	@Override
	public Bookings getBookingsByBookingId(int bookingId) {
		Bookings booking= bookingsDAO.getBookingsByBookingId(bookingId);
		return booking;
	}

	@Override
	public void createBookings(Bookings booking) {
		bookingsDAO.createBookings(booking);
		
	}

	@Override
	public void deleteBookings(int bookingId) {
		bookingsDAO.deleteBookings(bookingId);
	}

	@Override
	public List<Bookings> getBookingsByRoomNameAndDate(String roomName, LocalDate date) {
	return bookingsDAO.getBookingsByRoomNameAndDate(roomName, date);
	}

}

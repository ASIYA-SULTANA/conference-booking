package org.accion.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.accion.entity.Bookings;
import org.springframework.stereotype.Repository;

@Transactional
@Repository

public class BookingsDAO implements IBookingsDAO{
	@PersistenceContext	
	private EntityManager entityManager1;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Bookings> getAllBookings() {
		return (List<Bookings>) entityManager1.createQuery("select roomName, date, startTime, endTime, user  from Bookings").getResultList();
	}

	@Override
	public Bookings getBookingsByBookingId(int bookingId) {
		return entityManager1.find(Bookings.class, bookingId);
	}

	@Override
	public void createBookings(Bookings booking) {
		entityManager1.persist(booking);
		
	}

	@Override
	public void deleteBookings(int bookingId) {
		entityManager1.remove(getBookingsByBookingId(bookingId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bookings> getBookingsByRoomNameAndDate(String roomName, LocalDate date) {
	
		return (List<Bookings>) entityManager1.createQuery("select roomName, date, "
				+ "startTime,endTime from bookings where roomName='roomName' and date='date'")
			.getResultList();
	}

}

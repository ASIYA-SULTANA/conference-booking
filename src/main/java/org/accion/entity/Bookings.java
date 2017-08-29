package org.accion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;
import java.time.LocalDate;


@Entity
@Table(name="bookings")
public class Bookings {
	@Id
	@Column(name="bookingId")
	int bookingId;
	
	@Column(name="roomName")
	String roomName;
	
	@Column(name="user")
	String userName;
	
	@Column(name="startTime")
	LocalTime startTime;
	
	@Column(name="endTime")
	LocalTime endTime;
	
	@Column(name="date")
	LocalDate date;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}

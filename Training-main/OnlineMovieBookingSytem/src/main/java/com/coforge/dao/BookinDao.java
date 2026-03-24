package com.coforge.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coforge.entites.Booking;
import com.coforge.entites.Movie;
import com.coforge.repoistry.BookingRepositry;

@Repository
public class BookinDao {
	@Autowired
	BookingRepositry bookingRepositry;
	
	public List<Booking> getAllBookings(){
		return bookingRepositry.findAll();
	}
	public Booking addBooking(Booking booking)
	{
		return bookingRepositry.save(booking);
	}
	public Optional<Booking> getBookinById(Long bookingid)
	{
		return  bookingRepositry.findById(bookingid);
	}
	public List<Booking> getAllBookingByCustomerName(@Param("cname") String cname)
	{
		return bookingRepositry.getAllBookingsByCustomerName(cname);
	}
	public List<Booking> getAllBookingsByBookingDate(LocalDate bookingDate)
	{
		return bookingRepositry.getAllBookingsByBookingDate(bookingDate);
	}
	public Booking getBookingByCnameAndMobile(String cname,String cmobile)
	{
		return bookingRepositry.getBookingByCnameAndMobile(cname,cmobile);
	}


}

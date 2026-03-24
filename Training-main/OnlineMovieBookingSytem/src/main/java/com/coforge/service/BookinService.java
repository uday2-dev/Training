package com.coforge.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.coforge.dao.BookinDao;
import com.coforge.entites.Booking;
import com.coforge.repoistry.BookingRepositry;

@Service
public class BookinService {

	@Autowired
	BookinDao bookinDao;
	
	public List<Booking> getAllBookings(){
		return bookinDao.getAllBookings();
	}
	public Booking addBooking(Booking booking)
	{
		return bookinDao.addBooking(booking);
	}
	public Booking getBookinById(Long bookingid)
	{
		return  bookinDao.getBookinById(bookingid).orElseThrow(()->new RuntimeException());
	}
	public List<Booking> getAllBookingByCustomerName(@Param("cname") String cname)
	{
		return bookinDao.getAllBookingByCustomerName(cname);
	}
	public List<Booking> getAllBookingsByBookingDate(LocalDate bookingDate)
	{
		return bookinDao.getAllBookingsByBookingDate(bookingDate);
	}
	public Booking getBookingByCnameAndMobile(String cname,String cmobile)
	{
		return bookinDao.getBookingByCnameAndMobile(cname,cmobile);
	}


}

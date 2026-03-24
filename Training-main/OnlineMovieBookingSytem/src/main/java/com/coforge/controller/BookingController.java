package com.coforge.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.dao.BookinDao;
import com.coforge.entites.Booking;
import com.coforge.service.BookinService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookinService bookinService;
	
	@GetMapping("/")
	public List<Booking> getAllBookings(){
		return bookinService.getAllBookings();
	}
	@PostMapping("/")
	public Booking addBooking(@RequestBody Booking booking)
	{
		return bookinService.addBooking(booking);
	}
	@GetMapping("/{bookingid}")
	public Booking getBookingId(@PathVariable("bookingid") long bookingid)
	{
		return  bookinService.getBookinById(bookingid);
	}
	@GetMapping("/bookingDate/{bookingDate}")
	public List<Booking> getAllBookingsByBookingDate(@PathVariable("bookingDate")LocalDate bookingDate)
	{
		return bookinService.getAllBookingsByBookingDate(bookingDate);
	}
	@GetMapping("/bookingcnameandmobile/{cname,cmobile}")
	public Booking getBookingByCnameAndMobile(String cname,String cmobile)
	{
		return bookinService.getBookingByCnameAndMobile(cname,cmobile);
	}
}

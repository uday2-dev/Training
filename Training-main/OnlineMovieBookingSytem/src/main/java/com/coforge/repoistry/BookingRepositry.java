//package com.coforge.repoistry;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.coforge.entites.Booking;
//
//public interface BookingRepositry extends JpaRepository<Booking, Long> {
//	public List<Booking> findByShowTime(@Param("showtime") String showtime);
//	
//	@Query(value = "select * from booking where customer_name:cname",nativeQuery = true)
//	public List<Booking> getAllBookingsByCustomerName(@Param("cname") String cname);
//	@Query(value="select * from booking where seat_count=:seatcount",nativeQuery = true)
//	public List<Booking> getAllBookingByNumberOfSeats(@Param("seatcount")int seacount);
//	@Query("select b from Booking b where bookingDate=:bdate")
//	public List<Booking> getAllBookingsByBookingDate(@Param("bdate")LocalDate bookingDate);
//	
//	@Query("select b from Booking b where customerName=:cname and customerMobile=:cmobile")
//	public Booking getBookingByCnameAndMobile(@Param("cname")String cname,@Param("cmobile")String cmobile);
//	
//	
//}
package com.coforge.repoistry;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coforge.entites.Booking;

public interface BookingRepositry extends JpaRepository<Booking, Long> {
    List<Booking> findByShowtime(String showtime);
    @Query(value = "select * from booking where customername = :cname", nativeQuery = true)
    List<Booking> getAllBookingsByCustomerName(@Param("cname") String cname);
    @Query(value = "select * from booking where seacount = :seatcount", nativeQuery = true)
    List<Booking> getAllBookingByNumberOfSeats(@Param("seatcount") int seacount);
    @Query("select b from Booking b where b.bookingDate = :bdate")
    List<Booking> getAllBookingsByBookingDate(@Param("bdate") LocalDate bookingDate);
    
    @Query("select b from Booking b where customerName=:cname and customerMobile=:cmobile")
	public Booking getBookingByCnameAndMobile(@Param("cname")String cname,@Param("cmobile")String cmobile);
	
}
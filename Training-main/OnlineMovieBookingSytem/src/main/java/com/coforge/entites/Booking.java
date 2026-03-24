package com.coforge.entites;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//public class Booking {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long bookingid;
//	private String customername;
//	private String customermobilenum;
//	private int seacount;
//	private LocalDate bookingDate;
//	private String showtime;
//	private double totalamount;
//	@ManyToOne
//	@JoinColumn(name = "movieid")
//	private Movie movie;
//	public Booking(String customername, String customermobilenum, int seacount, LocalDate bookingDate, String showtime,
//			double totalamount, Movie movie) {
//		super();
//		this.customername = customername;
//		this.customermobilenum = customermobilenum;
//		this.seacount = seacount;
//		this.bookingDate = bookingDate;
//		this.showtime = showtime;
//		this.totalamount = totalamount;
//		this.movie = movie;
//	}
//	
//	
//
//}
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingid;

    private String customername;
    private String customermobilenum;
    private int seacount;
    private LocalDate bookingDate;
    private String showtime;
    private double totalamount;

    @ManyToOne
    @JoinColumn(name = "movieid")
    private Movie movie;

    public Booking(String customername, String customermobilenum, int seacount,
            LocalDate bookingDate, String showtime, double totalamount, Movie movie) {
        this.customername = customername;
        this.customermobilenum = customermobilenum;
        this.seacount = seacount;
        this.bookingDate = bookingDate;
        this.showtime = showtime;
        this.totalamount = totalamount;
        this.movie = movie;
    }
}
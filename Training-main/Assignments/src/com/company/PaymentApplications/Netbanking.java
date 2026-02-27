package com.coforge.PaymentApplications;

import java.util.Random;
import java.util.Scanner;

public class Netbanking implements paymentinterface {

    @Override
    public void pay(double amount) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        int otp = new Random().nextInt(9000) + 1000;
        System.out.println("Generated OTP: " + otp);

        System.out.print("Enter OTP: ");
        int enteredOtp = sc.nextInt();

        if (enteredOtp != otp) {
            System.out.println("Invalid OTP");
            return;
        }

        String txnId = "NET" + new Random().nextInt(10000);

        System.out.println("Payment of ₹" + amount + " Successful");
        System.out.println("Transaction ID: " + txnId);
    }
}
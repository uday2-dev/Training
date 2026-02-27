package com.coforge.PaymentApplications;

import java.util.Random;
import java.util.Scanner;

public class Upii implements paymentinterface {

    private int upiPin = 4321;

    @Override
    public void pay(double amount) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter UPI ID: ");
        String upiId = sc.next();

        System.out.print("Enter UPI PIN: ");
        int enteredPin = sc.nextInt();

        if (!upiId.contains("@")) {
            System.out.println("Invalid UPI ID");
            return;
        }

        if (enteredPin != upiPin) {
            System.out.println("Incorrect");
            return;
        }

        String txnId = "UPI" + new Random().nextInt(10000);

        System.out.println("Payment Successful");
        System.out.println("Transaction ID: " + txnId);
    }
}
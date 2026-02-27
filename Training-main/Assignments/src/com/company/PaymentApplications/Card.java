package com.coforge.PaymentApplications;

import java.util.Random;
import java.util.Scanner;

public class Card implements paymentinterface {

    @Override
    public void pay(double amount) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Card Number: ");
        String cardNumber = sc.next();

        System.out.print("Enter CVV: ");
        int cvv = sc.nextInt();

        System.out.print("Enter Expiry (MM/YY): ");
        String expiry = sc.next();

        if (cardNumber.length() != 16 || cvv < 100 || cvv > 999) {
            System.out.println("Invalid Card Details");
            return;
        }

        String txnId = "CARD" + new Random().nextInt(10000);

        System.out.println("Processing Payment...");
        System.out.println("Payment of ₹" + amount + " Successfuls");
        System.out.println("Transaction ID: " + txnId);
    }
}

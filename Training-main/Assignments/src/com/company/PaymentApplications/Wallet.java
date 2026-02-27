package com.coforge.PaymentApplications;
import java.util.Random;
import java.util.Scanner;

public class Wallet implements paymentinterface {

    private double balance = 5000;
    private int pin = 1234;

    @Override
    public void pay(double amount) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Current Wallet Balance: ₹" + balance);
        System.out.print("Enter Wallet PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin != pin) {
            System.out.println("Incorrect PIN! Transaction Failed");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance ❌");
            return;
        }

        balance -= amount;

        String txnId = "WAL" + new Random().nextInt(10000);

        System.out.println("Payment Successful");
        System.out.println("Transaction ID: " + txnId);
        System.out.println("Remaining Balance: ₹" + balance);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybankmachine;

import java.text.DecimalFormat;

/**
 *
 * @author rodec8600
 */
public class ATM {

    //declare the variables
    private String bank;
    private double balance, interest;
    private DecimalFormat x = new DecimalFormat("$##.00");

    /**
     * Constructor for accepting all inputs PRE: a bank, a balance, and an
     * interest rate POST: the variables are initialized
     */
    public ATM(String bankIn, double balanceIn, double interestIn) {
        bank = bankIn;
        balance = balanceIn;
        interest = interestIn / 100 / 365;
    }

    /**
     * To make deposits PRE: a deposit amount POST: balance increased by deposit
     * amount
     */
    public void deposit(double deposit) {
        if (deposit >= 0) {
            balance += deposit;
        } else {
            System.out.println("To remove money from your account, please use the withdrawal feature.");
        }
    }

    /**
     * To make withdrawals PRE: a withdrawal amount POST: balance decreased by
     * withdrawal amount
     */
    public void withdrawal(double withdrawal) {
        if (withdrawal >= 0) {
            balance -= withdrawal;
        } else {
            System.out.println("To add money to your account, please use the deposit feature.");
        }
    }

    /**
     * To make money over time using COMPOUND INTEREST PRE: amount of time to do
     * nothing POST: balance increased by amount generated
     */
    public void interest(double daysSpent) {
        if (daysSpent >= 0) {

            double notDoneYet = Math.pow((1 + interest), daysSpent);
            balance = balance * notDoneYet;
        } else {
            System.out.println("This ATM does not permit backwards time travel. You can go forwards only.");
        }
    }

    /**
     * Display the balance and things after each transaction POST: the balance
     * and bank are displayed
     */
    public String displayBalance() {
        String output = "Your balance with ";
        output += bank;
        output += " is ";
        output += x.format(balance);
        output += ".";
        return output;
    }

}

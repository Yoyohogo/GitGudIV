/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybankmachine;

import java.util.Scanner;

/**
 * To function as an ATM
 *
 * @author rodec8600
 */
public class MyBankMachine {

    /**
     * @param args the command line arguments
     */
    //set up the scanner (globally)
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //delcare variables by default
        boolean loop = true;
        String bank = "lol";
        double balance = 1200.00;
        double interest = 1.0;
        
        //run this code until user provides valid input
        //accepts input for bank, initial balance, and interest rate
        do {
            try {

                System.out.println("Please enter your bank:");
                bank = scanner.nextLine();
                System.out.println("Please enter your bank balance in $:");
                balance = Double.parseDouble(scanner.nextLine());
                System.out.println("Please enter your annual interest rate in %:");
                interest = Double.parseDouble(scanner.nextLine());
                loop = false;
            } catch (Exception e) {
                System.out.println("Please provide valid input.");
                loop = true;
            }
        } while (loop);

        //create an ATM object!
        ATM atm1 = new ATM(bank, balance, interest);

        //loop this code until user provides valid input
        //displays the menu and allows the user to pick what to do
        do {
            try {
                System.out.println("1.\tDeposit\n2.\tWithdraw\n3.\tInterest\n4.\tExit");
                int selection = Integer.parseInt(scanner.nextLine());
                selectionMethod(selection, atm1);
                loop = true;
            } catch (Exception e) {
                System.out.println("Please provide valid input.");
            }
        } while (loop);
    }

    /**
     * To decide what is done for each input
     * PRE: an int for selection and an ATM object 
     */
    private static void selectionMethod(int selection, ATM atm1) {
        
        //make sure the user provides good input, send them to the menu if they fail
        try {
            if (selection == 1) {
                System.out.println("Please enter a deposit amount in $:");
                double deposit = Double.parseDouble(scanner.nextLine());
                atm1.deposit(deposit);
                System.out.println(atm1.displayBalance());
            } else if (selection == 2) {
                System.out.println("Please enter a withraw amount in $:");
                double withdraw = Double.parseDouble(scanner.nextLine());
                atm1.withdrawal(withdraw);
                System.out.println(atm1.displayBalance());
            } else if (selection == 3) {
                System.out.println("Please enter an amount of days to do nothing for:");
                double days = Double.parseDouble(scanner.nextLine());
                atm1.interest(days);
                System.out.println(atm1.displayBalance());
            } else {
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Please provide valid input.");
        }
    }
}

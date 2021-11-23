package com.stockAccount;
import java.util.Scanner;

public class Account {
	

	static int amount =0;
	
	Scanner scan = new Scanner(System.in);
	
	public static int getAmount() {
		return amount;
	}

	public static void setAmount(int amount) {
		Account.amount = amount;
	}
	
	public void credit() {
		System.out.print(" Please enter the amount to credit: ");
		double credit_value = scan.nextDouble();
		
		amount += credit_value;
		System.out.println(" The current balance is : " + amount);		
	}
	
	public void debit() {
		System.out.print(" Please enter the amount to debit: ");
		double debit_value = scan.nextDouble();
		
		if (amount - debit_value < 0) {
			System.out.println(" Insufficient funds ");
			return;
		}
		
		amount -= debit_value;
		System.out.println(" The current balance is :: " + amount);	
		
		
	}
	
	public void amountUpdate() {
		amount -= Stock.getTotal_value();
		System.out.println(" The Account balance is :: " + amount);	
	}
}



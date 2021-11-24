package com.stockAccount;
import java.util.Scanner;

public class Account {
	
static double amount = 0;
	
	Scanner scan = new Scanner(System.in);

	public static void credit(double credit_value) {
		
		double temp_amount = Account.getAmount();
		temp_amount += credit_value;
		Account.setAmount(temp_amount);
		System.out.println(" Updated amount: " + Account.getAmount());		
	}
	
	public static boolean debit(double debit_value) {
		
		if (Account.getAmount() - debit_value < 0) {
			System.out.println(" Insufficient funds!");
			return false;
		}
		
		double temp_amount = Account.getAmount();
		temp_amount -= debit_value;
		Account.setAmount(temp_amount);
		
		return true;
	}  

public static double getAmount() {
	return amount;
}

public static void setAmount(double amount) {
	Account.amount = amount;
}

}



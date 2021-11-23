package com.stockAccount;
import java.util.List;
import java.util.Scanner;

	public class StockManager {

		public void addStock() {
			if (Stock.getTotal_value() <= Account.getAmount()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter total number of stocks to buy : ");
			int s = sc.nextInt();      
			double total_value = 0;
			double value = 0;

			List<StockPortfolio> temp = Stock.getStocks();
			for (int i = 0; i < s; i++) {
				StockPortfolio stock = new StockPortfolio();
				 		
				System.out.println("Please enter the name of the script: ");
				stock.setStockName(sc.next());
				System.out.println("Please enter the total number of shares you want to buy: ");
				stock.setQuantity(sc.nextInt());
				System.out.println("Please enter the price per share: ");
				stock.setPerSharePrice(sc.nextDouble());
				
				value = stock.getQuantity() * stock.getPerSharePrice();
				stock.setTotalSharePrice(value);
				temp.add(stock);
				Stock.setStocks(temp);
				total_value += value;
			}
				Stock.setTotal_value(total_value);	
		} else {
			System.out.println("Unable to add share due to insufficient balance in account. Please credit amount!!");
		}
		}

	
		public void printStock() {
			if (Stock.getTotal_value() < Account.getAmount()) {
			Account au = new Account();
			List<StockPortfolio > temp = Stock.getStocks();
			for (StockPortfolio stocks : temp) {
				System.out.println(stocks);
			}
			System.out.println(" \n Total value of stock in your trading account is: " + Stock.getTotal_value());
			au.amountUpdate();
		}
	     else {
			System.out.println("Stock not added as insufficient balance in account. Please credit amount!!");
		}
	}
	}
	


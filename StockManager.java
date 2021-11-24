package com.stockAccount;
import java.util.List;
import java.util.Scanner;

	public class StockManager implements StockAccountInterface {

		Scanner sc = new Scanner(System.in);
		
		public double valueOf() {

			System.out.println(" The current balance in account is: " + Account.getAmount());
			return Account.getAmount();
		}

		public StockPortfolio findStock(String name) {
			List<StockPortfolio> temp = Stock.getStocks();

			for (StockPortfolio stock : temp) {
				if (stock.getStockName().equals(name)) {
					return stock;
				}
			}

			return null;
		}

		public StockPortfolio createStock(String name) {
			List<StockPortfolio> temp = Stock.getStocks();

			System.out.print(" Enter the price per share: ");
			double price_of_share = sc.nextDouble();

			StockPortfolio stock = new StockPortfolio();
			stock.setStockName(name);
			stock.setQuantity(0);
			stock.setPerSharePrice(price_of_share);
			temp.add(stock);

			Stock.setStocks(temp);

			return stock;
		}

		public void buy(int amount, String symbol) {

			if (amount > Account.getAmount()) {
				System.out.println(" Insufficient funds!");
				return;
			}

			StockPortfolio stock = findStock(symbol);

			if (stock == null) {
				stock = createStock(symbol);
			}

			int quantity = (int) (amount / stock.getPerSharePrice());
			double debit_value = quantity * stock.getPerSharePrice();
			Account.debit(debit_value);
			stock.setQuantity(quantity + stock.getQuantity());
			stock.setTotalSharePrice(stock.getQuantity() * stock.getPerSharePrice());

		}

		public void sell(int amount, String symbol) {

			StockPortfolio stock = findStock(symbol);

			if (stock == null) {
				System.out.println(" You do not possess this stock!");
				return;
			}

			int quantity = (int) (amount / stock.getPerSharePrice());

			if (quantity > stock.getQuantity()) {
				quantity = stock.getQuantity();
			}

			stock.setQuantity(stock.getQuantity() - quantity);

			double stock_value = stock.getQuantity() * stock.getPerSharePrice();
			stock.setTotalSharePrice(stock_value);

			double credit_value = stock.getPerSharePrice() * quantity;
			Account.credit(credit_value);

		}

		public void printReport() {

			List<StockPortfolio> temp = Stock.getStocks();
			int value = 0;

			for (StockPortfolio stock : temp) {
				System.out.println(stock);
				value += stock.getTotalSharePrice();
			}

			System.out.println(" Your entire portfolio is worth: " + value);

		}

}
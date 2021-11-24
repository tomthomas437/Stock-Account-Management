package com.stockAccount;
import java.util.ArrayList;
import java.util.List;

	public class Stock {
		
		
		private static List<StockPortfolio> stocks = new ArrayList<StockPortfolio>();
		
		private static double total_value;

		public static List<StockPortfolio> getStocks() {
			return stocks;
		}

		public static void setStocks(List<StockPortfolio> stocks) {
			Stock.stocks = stocks;
		}

		public static double getTotal_value() {
			return total_value;
		}

		public static void setTotal_value(double total_value) {
			Stock.total_value = total_value;
		}
		
	}
		

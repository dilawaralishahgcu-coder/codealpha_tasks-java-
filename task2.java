/*TASK 2: Stock Trading Platform
● Simulate a basic stock trading environment.
● Add features for market data display and buy/sell operations.
● Allow users to track portfolio performance over time.
● Use Object-Oriented Programming (OOP) to manage stocks, users and transactions.
● Optionally, include file I/O or database to persist portfolio data. */
// Remember thar java is an pure object oriented programming lnaguage.

//using the concepts of object oriented programming
// java is an pure object oriented programming language
// WHY WE USE OOP ????????
// TO MAP WITH REAL WORLD SCENARIOS WE STARTED USING THE OBJECTS IN CODE CALLED AS THE OBJECT ORINETED PROGRAMMING
// A CLASS AND OBECJT IS THE BUILDING BLOCK OF OBJECT ORIN TD PROGRAMMING

import java.util.*;   // for importing the scanner class

class Stock {
    // ATTRIBUTES
    private String symbol;   // private & public are the access modifiers in java
    private double price;

    // this is a special pointer in java that points to the current object
    // Stock is the constuctor and the name of the constructor is the same as the name of the class with no return type
    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
// MEMBER FUCTIONS
    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return symbol + " ($" + price + ")";
    }
}

class Portfolio {
    private Map<String, Integer> holdings = new HashMap<>();
    private double balance;

    public Portfolio(double initialBalance) {
        this.balance = initialBalance;
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (cost <= balance) {
            balance -= cost;
            holdings.put(stock.getSymbol(), holdings.getOrDefault(stock.getSymbol(), 0) + quantity);
            System.out.println("Bought " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Not enough balance to complete purchase.");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        if (holdings.containsKey(stock.getSymbol()) && holdings.get(stock.getSymbol()) >= quantity) {
            holdings.put(stock.getSymbol(), holdings.get(stock.getSymbol()) - quantity);
            double revenue = stock.getPrice() * quantity;
            balance += revenue;
            System.out.println("Sold " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Not enough shares to sell.");
        }
    }

    public void viewPortfolio(Map<String, Stock> market) {
        System.out.println("\n=== Portfolio Summary ===");
        System.out.println("Balance: $" + balance);
        double totalValue = balance;
        for (String symbol : holdings.keySet()) {
            int qty = holdings.get(symbol);
            double stockValue = market.get(symbol).getPrice() * qty;
            totalValue += stockValue;
            System.out.println(symbol + " : " + qty + " shares (Value: $" + stockValue + ")");
        }
        System.out.println("Total Portfolio Value: $" + totalValue);
        System.out.println("=========================\n");
    }
}

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create sample market data
        Map<String, Stock> market = new HashMap<>();
        market.put("AAPL", new Stock("AAPL", 150.0));
        market.put("GOOG", new Stock("GOOG", 2800.0));
        market.put("TSLA", new Stock("TSLA", 700.0));
        market.put("AMZN", new Stock("AMZN", 3400.0));

        // Create user portfolio
        Portfolio portfolio = new Portfolio(5000.0);

        // Menu loop
        while (true) {
            System.out.println("=== Stock Trading Platform ===");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Market Data ---");
                    for (Stock s : market.values()) {
                        System.out.println(s);
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = sc.next().toUpperCase();
                    if (market.containsKey(buySymbol)) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        portfolio.buyStock(market.get(buySymbol), qty);
                    } else {
                        System.out.println("Invalid stock symbol.");
                    }
                    break;

                case 3:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = sc.next().toUpperCase();
                    if (market.containsKey(sellSymbol)) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        portfolio.sellStock(market.get(sellSymbol), qty);
                    } else {
                        System.out.println("Invalid stock symbol.");
                    }
                    break;

                case 4:
                    portfolio.viewPortfolio(market);
                    break;

                case 5:
                    System.out.println("Exiting... Thank you for trading!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

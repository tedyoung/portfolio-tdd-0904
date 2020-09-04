package com.tedmyoung.portfolio;

import java.time.LocalDate;

public class Portfolio {
  private int value = 0;
  private String symbol;
  private int qty;
  private int price;
  private LocalDate date;

  public int value() {
    return value;
  }

  public void buy(String symbol, int qty, int price, LocalDate date) {
    this.symbol = symbol;
    this.qty = qty;
    this.price = price;
    this.date = date;
    value += qty * price;
  }

  public String display() {
    return symbol + " " + qty + " $" + price + " " + date;
  }
}

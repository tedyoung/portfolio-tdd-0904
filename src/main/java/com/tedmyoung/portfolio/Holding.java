package com.tedmyoung.portfolio;

import java.time.LocalDate;

public class Holding {
  private final String symbol;
  private final int qty;
  private final int price;
  private final LocalDate date;
  private final int value;

  public Holding(String symbol, int qty, int price, LocalDate date) {
    this.symbol = symbol;
    this.qty = qty;
    this.price = price;
    this.date = date;
    value = qty * price;
  }

  public int value() {
    return value;
  }

  public String display() {
    return symbol + " " + qty + " $" + price + " " + date;
  }
}

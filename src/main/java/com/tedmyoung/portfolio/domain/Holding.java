package com.tedmyoung.portfolio.domain;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Holding holding = (Holding) o;

    if (qty != holding.qty) return false;
    if (price != holding.price) return false;
    if (!symbol.equals(holding.symbol)) return false;
    return date.equals(holding.date);
  }

  @Override
  public int hashCode() {
    int result = symbol.hashCode();
    result = 31 * result + qty;
    result = 31 * result + price;
    result = 31 * result + date.hashCode();
    return result;
  }

  public String symbol() {
    return symbol;
  }

  public int qty() {
    return qty;
  }

  public int price() {
    return price;
  }

  public LocalDate date() {
    return date;
  }
}

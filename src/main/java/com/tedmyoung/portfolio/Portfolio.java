package com.tedmyoung.portfolio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Portfolio {
  private final List<Holding> holdings = new ArrayList<>();

  public int value() {
    return holdings.stream()
                   .mapToInt(Holding::value)
                   .sum();
  }

  public void buy(String symbol, int qty, int price, LocalDate date) {
    Holding holding = new Holding(symbol, qty, price, date);
    holdings.add(holding);
  }

  public List<String> display() {
    return holdings.stream()
                   .map(Holding::display)
                   .collect(Collectors.toUnmodifiableList());
  }


}

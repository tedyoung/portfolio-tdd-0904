package com.tedmyoung.portfolio.adapter;

import com.tedmyoung.portfolio.domain.Holding;
import com.tedmyoung.portfolio.domain.Portfolio;

import java.util.List;
import java.util.stream.Collectors;

public class PortfolioConsoleAdapter {
  private final Portfolio portfolio;

  public PortfolioConsoleAdapter(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  public List<String> display() {
    return portfolio.holdings().stream()
                    .map(this::toDisplay)
                    .collect(Collectors.toUnmodifiableList());
  }

  public String toDisplay(Holding holding) {
    return holding.symbol() + " " + holding.qty() + " $" + holding.price() + " " + holding.date();
  }

}

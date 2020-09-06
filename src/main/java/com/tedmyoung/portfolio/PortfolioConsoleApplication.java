package com.tedmyoung.portfolio;

import com.tedmyoung.portfolio.adapter.PortfolioConsoleAdapter;
import com.tedmyoung.portfolio.domain.Portfolio;

import java.time.LocalDate;
import java.util.List;

public class PortfolioConsoleApplication {
  public static void main(String[] args) {
    Portfolio portfolio = new Portfolio();
    portfolio.buy("AAPL", 100, 125, LocalDate.of(2020, 9, 3));
    portfolio.buy("AMD", 200, 90, LocalDate.of(2020, 9, 3));

    PortfolioConsoleAdapter adapter = new PortfolioConsoleAdapter(portfolio);
    List<String> strings = adapter.display();
    strings.forEach(System.out::println);
  }

}

package com.tedmyoung.portfolio.adapter;

import com.tedmyoung.portfolio.domain.Portfolio;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class PortfolioConsoleAdapterTest {

  @Test
  public void portfolioWithTwoHoldingsDisplaysProperly() throws Exception {
    Portfolio portfolio = new Portfolio();
    portfolio.buy("AAPL", 100, 125, LocalDate.of(2020, 9, 3));
    portfolio.buy("AMD", 200, 90, LocalDate.of(2020, 9, 3));
    PortfolioConsoleAdapter portfolioConsoleAdapter = new PortfolioConsoleAdapter(portfolio);

    assertThat(portfolioConsoleAdapter.display())
        .containsExactly("AAPL 100 $125 2020-09-03",
                         "AMD 200 $90 2020-09-03");
  }

}
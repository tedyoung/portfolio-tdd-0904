package com.tedmyoung.portfolio.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class PortfolioTest {
  @Test
  public void newPortfolioHasZeroValue() throws Exception {
    Portfolio portfolio = new Portfolio();

    assertThat(portfolio.value())
        .isZero();
  }

  @Test
  public void buy100SharesOfStockAt125ValuedAt12_500() throws Exception {
    Portfolio portfolio = new Portfolio();

    portfolio.buy("AAPL", 100, 125, LocalDate.of(2020, 9, 3));

    assertThat(portfolio.value())
        .isEqualTo(125 * 100);
  }

  @Test
  public void buySharesTwicePortfolioValuedAtSumOfShares() throws Exception {
    Portfolio portfolio = new Portfolio();

    portfolio.buy("AAPL", 100, 125, LocalDate.of(2020, 9, 3));
    portfolio.buy("AMD", 200, 90, LocalDate.of(2020, 9, 3));

    assertThat(portfolio.value())
        .isEqualTo(100 * 125 + 200 * 90);
  }

  @Test
  public void givenSingleStockHoldingShowsHoldingInformation() throws Exception {
    Portfolio portfolio = new Portfolio();
    portfolio.buy("AAPL", 100, 125, LocalDate.of(2020, 9, 3));

    assertThat(portfolio.holdings())
        .containsOnlyOnce(new Holding("AAPL", 100, 125, LocalDate.of(2020, 9, 3)));
  }


  @Test
  public void givenTwoStockHoldingsRequestForHoldingsReturnsBoth() throws Exception {
    Portfolio portfolio = new Portfolio();
    portfolio.buy("AAPL", 100, 125, LocalDate.of(2020, 9, 3));
    portfolio.buy("AMD", 200, 90, LocalDate.of(2020, 9, 3));

    assertThat(portfolio.holdings())
        .containsExactlyInAnyOrder(new Holding("AMD", 200, 90, LocalDate.of(2020, 9, 3)),
                                   new Holding("AAPL", 100, 125, LocalDate.of(2020, 9, 3)));
  }

}
package com.virtualpairprogrammers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.math.BigDecimal;

import org.junit.Test;
import org.mockito.Spy;

public class RepaymentAmountTests {
  @Spy
  LoanApplication loanApplication;

  @Test
  public void test1YearLoanWholePounds() {
    loanApplication = spy(new LoanApplication());
    loanApplication.setPrincipal(1200);
    loanApplication.setTermInMonths(12);
    doReturn(new BigDecimal(10)).when(loanApplication).getInterestRate();

    LoanCalculatorController controller = new LoanCalculatorController();
    controller.processNewLoanApplication(loanApplication);

    assertEquals(new BigDecimal(110), loanApplication.getRepayment());
  }
}

package com.pattern.factorymethod;

import java.util.Random;

public abstract class BankAccountFactory {

  private static final int MAX_ACCOUNT_NUMBER = 999999999;
  private static final int MIN_ACCOUNT_NUMBER = 1;

  private static final Random random = new Random();

  protected String generateAccountNumber() {
    int randomNumber = random.nextInt(MIN_ACCOUNT_NUMBER, MAX_ACCOUNT_NUMBER - MIN_ACCOUNT_NUMBER);
    return String.format("%09d", randomNumber);
  }

  protected abstract BankAccount create(String ownerName);

}

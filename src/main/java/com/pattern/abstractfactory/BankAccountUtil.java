package com.pattern.abstractfactory;


import java.util.List;
import java.util.Random;

public class BankAccountUtil {

  private static final int MAX_ACCOUNT_NUMBER = 999999999;
  private static final int MIN_ACCOUNT_NUMBER = 1;

  private static final List<String> relationshipManagerList = List.of("Tom", "John", "Sam");
  private static final Random random = new Random();

  private BankAccountUtil() {

  }

  public static String generateAccountNumber() {
    int randomNumber = random.nextInt(MIN_ACCOUNT_NUMBER, MAX_ACCOUNT_NUMBER - MIN_ACCOUNT_NUMBER);
    return String.format("%09d", randomNumber);
  }

  public static String getRelationshipManagerName() {
    return relationshipManagerList.get(random.nextInt(relationshipManagerList.size()));
  }
}

package com.pattern.factorymethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestFactoryMethodPattern {

  private static final Logger logger = LogManager.getLogger(TestFactoryMethodPattern.class);

  public static void main(String[] args) {
    BankAccountFactory premiumBankAccountFactory = new PremiumBankAccountFactory();
    BankAccountFactory simpleBankAccountFactory = new SimpleBankAccountFactory();

    BankAccount bankAccount1 = premiumBankAccountFactory.create("Customer One");
    BankAccount bankAccount2 = simpleBankAccountFactory.create("Customer Two");

    logger.info("bankAccount1: {}", bankAccount1);
    logger.info("bankAccount2: {}", bankAccount2);

  }
}

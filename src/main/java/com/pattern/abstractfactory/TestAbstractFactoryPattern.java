package com.pattern.abstractfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestAbstractFactoryPattern {

  private static final Logger logger = LogManager.getLogger(TestAbstractFactoryPattern.class);

  public static void main(String[] args) {
    BankAccountFactory bankAccountFactory1 = new PremiumBankAccountFactory();
    BankAccountFactory bankAccountFactory2 = new SimpleBankAccountFactory();

    BankAccount bankAccount1 = bankAccountFactory1.createAccount("Customer One");
    BankAccount bankAccount2 = bankAccountFactory2.createAccount("Customer Two");

    logger.info("bankAccount1: {}", bankAccount1);
    logger.info("bankAccount2: {}", bankAccount2);

  }
}

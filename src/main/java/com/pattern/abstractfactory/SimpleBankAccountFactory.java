package com.pattern.abstractfactory;

public class SimpleBankAccountFactory implements BankAccountFactory {

  @Override
  public BankAccount createAccount(String ownerName) {
    return new SimpleBankAccount(ownerName, BankAccountUtil.generateAccountNumber());
  }
}

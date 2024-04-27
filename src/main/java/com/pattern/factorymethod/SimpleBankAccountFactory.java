package com.pattern.factorymethod;

public class SimpleBankAccountFactory extends BankAccountFactory {

  @Override
  protected BankAccount create(String ownerName) {
    return new SimpleBankAccount(ownerName, super.generateAccountNumber());
  }
}

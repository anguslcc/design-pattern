package com.pattern.abstractfactory;

public class SimpleBankAccount extends BankAccount {

  protected SimpleBankAccount(String ownerName, String accountNumber) {
    super(ownerName, accountNumber);
  }

  @Override
  public String toString() {
    return "SimpleBankAccount{" +
        "ownerName='" + super.getOwnerName() + "'," +
        "accountNumber='" + super.getAccountNumber() + "'" +
        "} ";
  }
}

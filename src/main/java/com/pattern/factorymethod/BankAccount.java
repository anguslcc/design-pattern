package com.pattern.factorymethod;

public abstract class BankAccount {

  private final String ownerName;
  private final String accountNumber;

  protected BankAccount(String ownerName, String accountNumber) {
    this.ownerName = ownerName;
    this.accountNumber = accountNumber;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

}

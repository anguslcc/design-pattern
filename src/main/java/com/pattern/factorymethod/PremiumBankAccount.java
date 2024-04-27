package com.pattern.factorymethod;

public class PremiumBankAccount extends BankAccount {

  private String relationshipManagerName;

  protected PremiumBankAccount(String ownerName, String accountNumber) {
    super(ownerName, accountNumber);
  }

  public String getRelationshipManagerName() {
    return relationshipManagerName;
  }

  public void setRelationshipManagerName(String relationshipManagerName) {
    this.relationshipManagerName = relationshipManagerName;
  }

  @Override
  public String toString() {
    return "PremiumBankAccount{" +
        "ownerName='" + super.getOwnerName() + "'," +
        "accountNumber='" + super.getAccountNumber() + "'," +
        "relationshipManagerName='" + relationshipManagerName + "'" +
        "} ";
  }
}

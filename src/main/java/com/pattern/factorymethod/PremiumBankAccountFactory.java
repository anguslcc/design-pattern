package com.pattern.factorymethod;

import java.util.List;
import java.util.Random;

public class PremiumBankAccountFactory extends BankAccountFactory {

  private static final List<String> relationshipManagerList = List.of("Tom", "John", "Sam");

  private static final Random random = new Random();

  @Override
  protected BankAccount create(String ownerName) {
    PremiumBankAccount premiumBankAccount = new PremiumBankAccount(ownerName,
        generateAccountNumber());
    premiumBankAccount.setRelationshipManagerName(getRelationshipManagerName());
    return premiumBankAccount;
  }

  private String getRelationshipManagerName() {
    return relationshipManagerList.get(random.nextInt(relationshipManagerList.size()));
  }
}

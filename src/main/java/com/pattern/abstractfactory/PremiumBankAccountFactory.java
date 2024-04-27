package com.pattern.abstractfactory;

import java.util.List;
import java.util.Random;

public class PremiumBankAccountFactory implements BankAccountFactory {

  @Override
  public BankAccount createAccount(String ownerName) {
    PremiumBankAccount premiumBankAccount = new PremiumBankAccount(ownerName,
        BankAccountUtil.generateAccountNumber());
    premiumBankAccount.setRelationshipManagerName(BankAccountUtil.getRelationshipManagerName());
    return premiumBankAccount;
  }

}

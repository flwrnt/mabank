package com.exemple.mabank.converter;

import com.exemple.mabank.entity.AccountEntity;
import com.exemple.mabank.model.Account;

public class AccountConverter {

  public static Account toModel(AccountEntity entity) {
    return new Account(entity.getId(), entity.getLabel(), entity.getAmount(), entity.getDevise());
  }

  public static AccountEntity toEntity(Account entity) {
    return new AccountEntity(entity.getId(), entity.getLabel(), entity.getMoney(), entity.getDevise());
  }
}

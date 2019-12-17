package com.exemple.mabank.converter;

import com.exemple.mabank.dto.AccountDto;
import com.exemple.mabank.model.Account;

public class AccountDtoConverter {

  public static AccountDto toDto(Account account) {
    return new AccountDto(account.getId(), account.getLabel(), account.getMoney(), account.getDevise());
  }

  public static Account fromDto(AccountDto accountDto) {
    return new Account(accountDto.getId(), accountDto.getLabel(), accountDto.getMoney(), accountDto.getDevise());
  }
}

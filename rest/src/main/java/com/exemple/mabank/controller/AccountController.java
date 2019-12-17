package com.exemple.mabank.controller;

import com.exemple.mabank.api.AccountApi;
import com.exemple.mabank.converter.AccountDtoConverter;
import com.exemple.mabank.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements AccountApi {

  @Autowired
  private AccountApi accountService;

  @Override
  public AccountDto save(AccountDto accountDto) {
    return AccountDtoConverter.toDto(AccountDtoConverter.fromDto(accountDto));
  }
}

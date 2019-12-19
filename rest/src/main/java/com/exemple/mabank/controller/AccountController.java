package com.exemple.mabank.controller;

import com.exemple.mabank.AccountService;
import com.exemple.mabank.api.AccountApi;
import com.exemple.mabank.converter.AccountDtoConverter;
import com.exemple.mabank.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = { "*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class AccountController implements AccountApi {

  @Autowired
  private AccountService accountService;

  @Override
  public List<AccountDto> getAllAccounts() {
    return accountService.findAll().stream().map(AccountDtoConverter::toDto).collect(Collectors.toList());
  }

  @Override
  public AccountDto save(AccountDto accountDto) {
    return AccountDtoConverter.toDto(accountService.save(AccountDtoConverter.fromDto(accountDto)));
  }
}

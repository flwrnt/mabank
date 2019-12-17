package com.exemple.mabank.api;

import com.exemple.mabank.dto.AccountDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Account", description = "Gestion des comptes bancaire")
public interface AccountApi {

  @ApiOperation("Sauvegarde d'un compte bancaire")
  AccountDto save(AccountDto accountDto);
}

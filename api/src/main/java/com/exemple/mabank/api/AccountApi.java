package com.exemple.mabank.api;

import com.exemple.mabank.dto.AccountDto;
import com.exemple.mabank.model.Account;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Api(value = "Account", description = "Gestion des comptes bancaire")
public interface AccountApi {

  @GetMapping(path = "/accounts", produces = "application/json")
  @ApiOperation("Récupérartion des comptes bancaires")
  List<AccountDto> getAllAccounts();

  @PostMapping(path = "/account", produces = "application/json")
  @ApiOperation("Sauvegarde d'un compte bancaire")
  AccountDto save(@RequestBody @ApiParam(value = "Compte a sauvegarder") AccountDto accountDto);

  @GetMapping(path = "/account/{id}", produces = "application/json")
  @ApiOperation("Récupérartion d'un compte bancaire")
  AccountDto getAccount(@PathVariable @ApiParam(value = "identifiant du compte") UUID id);
}

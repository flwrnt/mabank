package com.exemple.mabank.dao;

import com.exemple.mabank.model.Account;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface AccountDao {

  List<Account> findAll();

  Account findById(UUID id);

  Account save(Account account);

  void tansfertMoney(Account accountSender, Account accountReceiver, Double amount);
}

package com.exemple.mabank;

import com.exemple.mabank.dao.AccountDao;
import com.exemple.mabank.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

  @Autowired
  private AccountDao accountDao;

  public List<Account> findAll() {
    return accountDao.findAll();
  }

  public Account save(Account account) {
    return accountDao.save(account);
  }

  public Account findById(UUID id) {
    return accountDao.findById(id);
  }
}

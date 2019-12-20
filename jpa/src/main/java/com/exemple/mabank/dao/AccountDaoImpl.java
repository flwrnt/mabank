package com.exemple.mabank.dao;

import com.exemple.mabank.converter.AccountConverter;
import com.exemple.mabank.entity.AccountEntity;
import com.exemple.mabank.model.Account;
import com.exemple.mabank.repository.AccountRepository;
import javassist.NotFoundException;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountDaoImpl implements AccountDao {

  @Autowired
  private AccountRepository accountRepository;

  @Override
  @Transactional
  public List<Account> findAll() {
    List<AccountEntity> accounts = accountRepository.findAll();
    return accounts.stream().map(AccountConverter::toModel).collect(Collectors.toList());
  }

  @Override
  public Account findById(UUID id) {
    Optional<AccountEntity> optAccount = accountRepository.findById(id);

    if (optAccount.isEmpty()) {
      throw new RuntimeException("le compte n'existe pas");
    }

    return AccountConverter.toModel(optAccount.get());
  }

  @Override
  public Account save(Account account) {
    return AccountConverter.toModel(accountRepository.save(AccountConverter.toEntity(account)));
  }

  @Override
  public void tansfertMoney(Account accountSender, Account accountReceiver, Double amount) {
    throw new NotYetImplementedException("todo");
  }
}

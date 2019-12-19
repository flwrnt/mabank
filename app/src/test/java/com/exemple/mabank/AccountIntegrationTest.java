package com.exemple.mabank;

import com.exemple.mabank.model.Account;
import com.exemple.mabank.model.Devise;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class AccountIntegrationTest {

  @Autowired
  private AccountService accountService;

  @Test
  @DatabaseSetup("classpath:database.xml")
  public void testFindAllAccount() {
    List<Account> accounts = accountService.findAll();
    System.out.println(accounts);

    assertThat(accounts, hasSize(1));
  }

  @Test
  @DatabaseSetup("classpath:database.xml")
  public void testSaveAccount() {
    assertThat(accountService.findAll(), hasSize(1));

    UUID uuid = UUID.randomUUID();
    Account account = accountService.save(new Account(uuid, "compte X", 100., Devise.EUR));
    System.out.println(account);

    assertEquals(uuid, account.getId());
    assertEquals("compte X", account.getLabel());
    assertEquals(Double.valueOf(100.), account.getMoney());
    assertEquals(Devise.EUR, account.getDevise());

    assertThat(accountService.findAll(), hasSize(2));
  }
}

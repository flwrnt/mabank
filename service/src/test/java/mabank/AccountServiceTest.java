package mabank;

import com.exemple.mabank.AccountService;
import com.exemple.mabank.dao.AccountDao;
import com.exemple.mabank.model.Account;
import com.exemple.mabank.model.Devise;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

  @InjectMocks
  private AccountService accountService;

  @Mock
  private AccountDao accountDao;


  @Test
  public void testFindById() {

    UUID uuid = UUID.randomUUID();
    Account account = new Account(uuid, "cpmte Y", 10.7, Devise.EUR);

    given(accountDao.findById(uuid)).willReturn(account);

    accountService.findById(uuid);

    then(accountDao).should(times(1)).findById(uuid);
  }
}

package pl.carRent.services.implement;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.carRent.configuration.TestConfiguration;
import pl.carRent.database.IAccountDAO;
import pl.carRent.database.ICarDAO;
import pl.carRent.database.IRentDAO;
import pl.carRent.models.Account;
import pl.carRent.models.UserType;
import pl.carRent.services.IAccountServices;
import pl.carRent.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class AccountServiceTest {

    @MockBean
    SessionObject sessionObject;

    @Autowired
    IAccountServices accountServices;

    @MockBean
    IAccountDAO accountDAO;

    @MockBean
    ICarDAO carDAO;

    @MockBean
    IRentDAO rentDAO;


    @Test
    public void correctAccountType(){
        Mockito.when(this.sessionObject.getAccount()).thenReturn(generateAccountWithUserType());
        Assert.assertTrue(accountServices.checkAccountType());
    }

    @Test
    public void incorrectAccountType(){
        Mockito.when(this.sessionObject.getAccount()).thenReturn(generateAccountWithUserType());
        sessionObject.getAccount().setUserType(UserType.DEFAULT);
        Assert.assertFalse(accountServices.checkAccountType());
    }


    public Account generateAccountWithUserType(){
        Account account = new Account();
        account.setLogin("admin");
        account.setPassword("admin");
        account.setName("pawel");
        account.setSurname("dziwisz");
        account.setAge(23);
        account.setUserType(UserType.ADMIN);
        return account;
    }
}

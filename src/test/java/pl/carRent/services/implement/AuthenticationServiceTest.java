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
import pl.carRent.configuration.AppConfiguration;
import pl.carRent.configuration.TestConfiguration;
import pl.carRent.database.IAccountDAO;
import pl.carRent.database.ICarDAO;
import pl.carRent.database.IRentDAO;
import pl.carRent.models.Account;
import pl.carRent.models.UserType;
import pl.carRent.services.IAuthenticationService;
import pl.carRent.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class AuthenticationServiceTest {

    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionObject sessionObject;

    @MockBean
    IAccountDAO accountDAO;

    @MockBean
    ICarDAO carDAO;

    @MockBean
    IRentDAO rentDAO;

    public Optional<Account> generateAccount(){
        Account account = new Account();
        account.setLogin("admin");
        account.setPassword("admin");
        account.setName("pawel");
        account.setSurname("dziwisz");
        account.setAge(23);
        account.setUserType(UserType.ADMIN);
        return Optional.of(account);
    }
    @Test
    public void correctAuthentication(){
        Mockito.when(this.accountDAO.getUserByLogin("admin")).thenReturn(generateAccount());
        String login="admin";
        String password="admin";

        this.authenticationService.authentication(login,password);

        Assert.assertTrue(this.sessionObject.isLogged());

    }
    @Test
    public void incorrectAuthentication(){
        Mockito.when(this.accountDAO.getUserByLogin("admin123")).thenReturn(Optional.empty());
        String login="admin";
        String password="admin";

        this.authenticationService.authentication(login,password);

        Assert.assertFalse(this.sessionObject.isLogged());

    }
}

package pl.carRent.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.carRent.database.IAccountDAO;
import pl.carRent.models.Account;
import pl.carRent.services.IAuthenticationService;
import pl.carRent.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    IAccountDAO accountDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public void authentication(String login, String password) {
        Optional<Account> account = accountDAO.getUserByLogin(login);
        if(account.isEmpty()){
            return;
        }
        this.sessionObject.setAccount(account.get());
    }
}

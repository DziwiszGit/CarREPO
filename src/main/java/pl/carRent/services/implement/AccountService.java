package pl.carRent.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.carRent.database.IAccountDAO;
import pl.carRent.models.Account;
import pl.carRent.models.UserType;
import pl.carRent.services.IAccountServices;
import pl.carRent.session.SessionObject;

@Service
public class AccountService implements IAccountServices {

    @Autowired
    IAccountDAO accountDAO;

    @Autowired
    SessionObject sessionObject;

    @Override
    public void addAccount(Account account) {
        accountDAO.addAccount(account);
    }

    @Override
    public boolean checkAccountType() {
        if(sessionObject.getAccount().getUserType() == UserType.ADMIN){
            return true;
        }else
            return false;
    }


}

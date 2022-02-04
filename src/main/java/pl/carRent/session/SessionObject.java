package pl.carRent.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.carRent.models.Account;

@Component
@SessionScope
public class SessionObject {
    private Account account = null;

    public boolean isLogged() {
        return this.account != null;
    }

    public Account getAccount() {
        return account;
    }


    public void setAccount(Account account) {
        this.account = account;
    }

}

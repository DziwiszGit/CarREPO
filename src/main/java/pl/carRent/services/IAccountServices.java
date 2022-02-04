package pl.carRent.services;

import pl.carRent.models.Account;

public interface IAccountServices {
    public void addAccount(Account account);
    public boolean checkAccountType();
}

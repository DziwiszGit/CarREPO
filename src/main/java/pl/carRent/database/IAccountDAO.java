package pl.carRent.database;

import pl.carRent.models.Account;

import java.util.Optional;

public interface IAccountDAO {
    public Optional<Account> getUserByLogin(String login);
    public void addAccount(Account account);
}

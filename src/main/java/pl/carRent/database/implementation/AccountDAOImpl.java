package pl.carRent.database.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.carRent.database.IAccountDAO;
import pl.carRent.models.Account;

import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
public class AccountDAOImpl implements IAccountDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<Account> getUserByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<Account> query = session.createQuery("FROM pl.carRent.models.Account WHERE login = :login");
        query.setParameter("login", login);
        try {
            Account user = query.getSingleResult();
            session.close();
            return Optional.of(user);
        } catch (NoResultException e) {
            session.close();
            return Optional.empty();
        }
    }

    @Override
    public void addAccount(Account account) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(account);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

}

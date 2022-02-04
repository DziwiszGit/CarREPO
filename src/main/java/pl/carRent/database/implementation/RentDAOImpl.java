package pl.carRent.database.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.carRent.database.IRentDAO;
import pl.carRent.models.Car;
import pl.carRent.models.RentCar;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class RentDAOImpl implements IRentDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void rentCar(RentCar rentCar) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(rentCar);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<RentCar> getCarList() {
        Session session = this.sessionFactory.openSession();
        Query<RentCar> query = session.createQuery("FROM pl.carRent.models.RentCar");
        List<RentCar> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public void deleteRent(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        Query<RentCar> query = session.createQuery("FROM pl.carRent.models.RentCar WHERE id = :id");
        query.setParameter("id", id);
        try {
            tx = session.beginTransaction();
            session.delete(query.getSingleResult());
            tx.commit();
        } catch (NoResultException e) {
            session.close();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public RentCar getRentCarById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<RentCar> query = session.createQuery("FROM pl.carRent.models.RentCar WHERE id = :id");
        query.setParameter("id", id);
        try {
            RentCar rentCar = query.getSingleResult();
            session.close();
            return rentCar;
        } catch (NoResultException e) {
            session.close();
            return null;
        }
    }
}

package pl.carRent.database.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.carRent.database.ICarDAO;
import pl.carRent.models.Car;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CarDAOImpl implements ICarDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addCar(Car car) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(car);
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
    public void deleteCar(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        Query<Car> query = session.createQuery("FROM pl.carRent.models.Car WHERE id = :id");
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
    public List<Car> getCarList() {
        Session session = this.sessionFactory.openSession();
        Query<Car> query = session.createQuery("FROM pl.carRent.models.Car");
        List<Car> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public Car getCarById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Car> query = session.createQuery("FROM pl.carRent.models.Car WHERE id = :id");
        query.setParameter("id", id);
        try {
            Car car = query.getSingleResult();
            session.close();
            return car;
        } catch (NoResultException e) {
            session.close();
            return null;
        }
    }


}

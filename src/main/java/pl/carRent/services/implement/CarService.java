package pl.carRent.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.carRent.database.ICarDAO;
import pl.carRent.models.Car;
import pl.carRent.services.ICarServices;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarService implements ICarServices {

    @Autowired
    ICarDAO carDAO;

    @Override
    public void addCar(Car car) {
        carDAO.addCar(car);
    }

    @Override
    public void deleteCar(int id) {
        carDAO.deleteCar(id);
    }

    @Override
    public List<Car> getCarList() {
        return this.carDAO.getCarList();
    }

}

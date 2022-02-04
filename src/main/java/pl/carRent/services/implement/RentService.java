package pl.carRent.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.carRent.database.ICarDAO;
import pl.carRent.database.IRentDAO;
import pl.carRent.models.Car;
import pl.carRent.models.RentCar;
import pl.carRent.services.IRentServices;

import java.util.List;

@Service
public class RentService implements IRentServices {

    @Autowired
    IRentDAO rentDAO;

    @Autowired
    ICarDAO carDAO;

    @Override
    public void rentCar(int id) {
        rentDAO.rentCar(changeCarToRentCar(carDAO.getCarById(id)));
        carDAO.deleteCar(id);
    }

    @Override
    public RentCar changeCarToRentCar(Car car) {
        return new RentCar(car.getBrand(),car.getModel(),car.getHorsePower(),car.getPricePerDay());
    }


    @Override
    public List<RentCar> getRentCarList() {
        return rentDAO.getCarList();
    }

    @Override
    public void deleteRent(int id) {
        carDAO.addCar(changeRentCarToCar(rentDAO.getRentCarById(id)));
        rentDAO.deleteRent(id);
    }

    @Override
    public Car changeRentCarToCar(RentCar rentCar) {
        return new Car(rentCar.getBrand(),rentCar.getModel(),rentCar.getHorsePower(),rentCar.getPricePerDay());
    }


}

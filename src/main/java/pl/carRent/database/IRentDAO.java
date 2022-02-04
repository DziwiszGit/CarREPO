package pl.carRent.database;

import pl.carRent.models.Car;
import pl.carRent.models.RentCar;

import java.util.List;

public interface IRentDAO {
    public void rentCar(RentCar rentCar);
    public List<RentCar> getCarList();
    public void deleteRent(int id);
    public RentCar getRentCarById(int id);
}

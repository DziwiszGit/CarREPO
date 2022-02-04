package pl.carRent.database;

import pl.carRent.models.Car;

import java.util.List;

public interface ICarDAO {
    public void addCar(Car car);
    public void deleteCar(int id);
    public List<Car> getCarList();
    public Car getCarById(int id);

}

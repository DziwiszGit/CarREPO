package pl.carRent.services;

import pl.carRent.models.Car;

import java.util.List;

public interface ICarServices {
    public void addCar(Car car);
    public void deleteCar(int id);
    public List<Car> getCarList();

}

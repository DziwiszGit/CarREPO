package pl.carRent.services;

import pl.carRent.models.Car;
import pl.carRent.models.RentCar;

import java.util.List;

public interface IRentServices {
    public void rentCar(int id);
    public RentCar changeCarToRentCar(Car car);
    public List<RentCar> getRentCarList();
    public void deleteRent(int id);
    public Car changeRentCarToCar(RentCar car);
}

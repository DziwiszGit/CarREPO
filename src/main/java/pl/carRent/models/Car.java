package pl.carRent.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tcar")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int horsePower;
    private double pricePerDay;

    public Car() {
    }

    public Car(String brand, String model, int horsePower, double pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
        this.pricePerDay = pricePerDay;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }
}

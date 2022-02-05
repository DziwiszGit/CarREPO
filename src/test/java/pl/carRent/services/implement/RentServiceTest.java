package pl.carRent.services.implement;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.carRent.configuration.TestConfiguration;
import pl.carRent.database.IAccountDAO;
import pl.carRent.database.ICarDAO;
import pl.carRent.database.IRentDAO;
import pl.carRent.models.Car;
import pl.carRent.models.RentCar;
import pl.carRent.services.IAuthenticationService;
import pl.carRent.services.IRentServices;
import pl.carRent.session.SessionObject;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class RentServiceTest {
    @Autowired
    IRentServices rentServices;

    @Resource
    SessionObject sessionObject;

    @MockBean
    IAccountDAO accountDAO;

    @MockBean
    ICarDAO carDAO;

    @MockBean
    IRentDAO rentDAO;

    @Test
    public void checkCorrectRentCarArgument(){
       Mockito.when(this.rentDAO.getRentCarById(1)).thenReturn(generateRentCar());

       Assert.assertTrue(this.rentServices.changeRentCarToCar(rentDAO.getRentCarById(1)) instanceof Car);
    }
    @Test
    public void checkCorrectCarArgument(){
        Mockito.when(this.carDAO.getCarById(1)).thenReturn(generateCar());

        Assert.assertTrue(this.rentServices.changeCarToRentCar(carDAO.getCarById(1)) instanceof RentCar);
    }
    public RentCar generateRentCar(){
        RentCar rentCar = new RentCar();
        rentCar.setId(1);
        rentCar.setBrand("Ford");
        rentCar.setModel("Focus");
        rentCar.setHorsePower(125);
        rentCar.setPricePerDay(150);
        return rentCar;
    }
    public Car generateCar(){
        Car car = new Car();
        car.setId(1);
        car.setBrand("Ford");
        car.setModel("Focus");
        car.setHorsePower(125);
        car.setPricePerDay(150);
        return car;
    }
}

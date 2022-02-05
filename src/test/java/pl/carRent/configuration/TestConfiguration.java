package pl.carRent.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.carRent.database.IAccountDAO;
import pl.carRent.database.ICarDAO;
import pl.carRent.database.IRentDAO;

@Configuration
@ComponentScan(basePackages = {
        "pl.carRent.controllers",
        "pl.carRent.services",
        "pl.carRent.session"
})
public class TestConfiguration {

//    @Bean
//    public IAccountDAO accountDAO(){
//        return Mockito.mock(IAccountDAO.class);
//    }
//
//    @Bean
//    public ICarDAO carDAO(){
//        return Mockito.mock(ICarDAO.class);
//    }
//
//    @Bean
//    public IRentDAO rentDAO(){
//        return Mockito.mock(IRentDAO.class);
//    }
}

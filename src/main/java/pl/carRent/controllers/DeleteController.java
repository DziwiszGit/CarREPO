package pl.carRent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.carRent.models.Car;
import pl.carRent.services.IAccountServices;
import pl.carRent.services.ICarServices;
import pl.carRent.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class DeleteController {

    @Resource
    SessionObject sessionObject;

    @Autowired
    ICarServices carServices;

    @Autowired
    IAccountServices accountServices;

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteCar(Model model){
        model.addAttribute("logged", sessionObject.isLogged());
        model.addAttribute("car",this.carServices.getCarList());
        model.addAttribute("userType",accountServices.checkAccountType());
        return "delete";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteCar(@RequestParam int id) {
        carServices.deleteCar(id);
        return "main";
    }

}

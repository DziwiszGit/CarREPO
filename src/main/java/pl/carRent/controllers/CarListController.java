package pl.carRent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.carRent.services.ICarServices;
import pl.carRent.services.IRentServices;
import pl.carRent.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class CarListController {

    @Resource
    SessionObject sessionObject;

    @Autowired
    ICarServices carServices;

    @Autowired
    IRentServices rentServices;

    @RequestMapping(value = "/carList",method = RequestMethod.GET)
    public String carList(Model model){
        model.addAttribute("logged", sessionObject.isLogged());
        model.addAttribute("car",this.carServices.getCarList());
        return "carList";
    }
    @RequestMapping(value = "/carList", method = RequestMethod.POST)
    public String rentCar(@RequestParam int id) {
        rentServices.rentCar(id);
        return "redirect:/info";
    }
}

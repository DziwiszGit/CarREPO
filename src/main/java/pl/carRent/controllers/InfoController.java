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
public class InfoController {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IRentServices rentServices;

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String infoAboutYourCars(Model model){
        model.addAttribute("logged", sessionObject.isLogged());
        model.addAttribute("rentCar",this.rentServices.getRentCarList());
        return "info";
    }
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String deleteRent(@RequestParam int id) {
        rentServices.deleteRent(id);
        return "redirect:/carList";
    }
}

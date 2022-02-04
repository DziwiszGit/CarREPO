package pl.carRent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.carRent.models.Account;
import pl.carRent.models.UserType;
import pl.carRent.services.IAccountServices;
import pl.carRent.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class RegisterController {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IAccountServices accountServices;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String basicInfoAboutSession(Model model){
        model.addAttribute("logged", sessionObject.isLogged());
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createNewAccount(@RequestParam String login,
                                   @RequestParam String password,
                                   @RequestParam String name,
                                   @RequestParam String surname,
                                   @RequestParam int age,
                                   @RequestParam UserType userType){
        Account account = new Account(login,password,name,surname,age,userType);
        accountServices.addAccount(account);
        return "redirect:/login";
    }
}

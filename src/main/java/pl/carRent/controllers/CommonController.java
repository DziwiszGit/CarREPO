package pl.carRent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.carRent.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class CommonController {

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String basic(Model model){
        model.addAttribute("logged", sessionObject.isLogged());
        return "main";
    }

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String basicLoginFromStartedPage(Model model){
        model.addAttribute("logged", sessionObject.isLogged());
        return "main";
    }
}

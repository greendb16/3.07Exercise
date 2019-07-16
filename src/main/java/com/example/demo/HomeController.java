package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    PeopleRepository peopleRepository;

    @RequestMapping("/")
    public String index(Model model) {
        People person = new People();
        person.setName("Joe Shmow");
        person.setSsn("5555555555");

        Passport passport = new Passport();
        passport.setPassportNumber(55599966);
        passport.setExpDate("12/5/25");

        person.setPassport(passport);
        peopleRepository.save(person);

        person = new People();
        person.setName("Sally Bo'Bally");
        person.setSsn("9966685465");

        passport = new Passport();
        passport.setPassportNumber(66689745);
        passport.setExpDate("11/8/21");

        person.setPassport(passport);
        peopleRepository.save(person);

        model.addAttribute("peoples", peopleRepository.findAll());
        return "index";

    }
}

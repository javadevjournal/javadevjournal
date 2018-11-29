package com.javadevjournal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {


    /**
     * <p></p>This method demonstrate the use @ModelAttribute annotation at the method level.
     * This method create a list and returns list of countries</p>
     *
     * @return list of countries
     */
    @ModelAttribute("countries")
    public List<String> populateCountries() {
        List<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("USA");
        countries.add("Japan");
        return countries;
    }

    /**
     * <p></p>This method is the variation of the above method.It will accept a model and save values in this mode.
     * These saved values will be available on the frontend to the custom</p>
     *
     * @param model
     */
    @ModelAttribute
    public void getStates(final Model model) {
        List<String> states = new ArrayList<>();
        states.add("California");
        states.add("New York");
        states.add("Alaska");
        states.add("Colorado");

        model.addAttribute("states",states);
    }

    /*
     * A handler method can have more then one parameters with @ModelAttribute
     * The following handler method will retrieve the 'countries','cities' and 'languages'
     *  attribute from the model
     */
    @GetMapping("/home")
    public String home(@ModelAttribute("countries") List<String> countries,
                           Model model) {

        //Add more countries
        countries.add("Australia");
        countries.add("Canada");
        return "home";
    }
}

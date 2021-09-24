package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.DayCalculation;

import java.time.LocalDate;
import java.util.Locale;

@RestController //this is how it knows it's a controller
public class HelloControllers {

    private DayCalculation dayCalculation = new DayCalculation();

    @GetMapping("/first-mapping")
    public String firstMapping() {
        return "Hello world";
    }

    //1.1 Exercise: Hello Spring
    @GetMapping("/") //front page, so to speak
    public String index() {
        return "<b>Welcome, friend!<b>";
    }

    //1.2 Exercise: Echo
    //Create an endpoint that echo's the users GET parameter from the URL.
    //E.g: http://localhost:8080/echo?input=HelloDat21v2 will display a message "HelloDat21v2" on screen.
    @GetMapping("/userInput")
    public String parameter(@RequestParam String input){
        //For this to work:
        //localhost:8080/userInput?input=HelloWorld
        return "You wrote: " + input;
    }

    //1.3 Exercise: ErDetFredag? (simple version)
    @GetMapping("/is-it-friday")
    public String isItFriday() {
        return dayCalculation.calculateDaySimple();
    }

    //1.3 Exercise: ErDetFredag? (advanced version)
    @GetMapping("/is-it-friday-advanced")
    public String isItFridayAdvanced() {
        return dayCalculation.calculateDay();
    }

    //just some fun
    @GetMapping("/what-day")
    public String whatDay() {
        return dayCalculation.returnDayOfWeek();
    }

}

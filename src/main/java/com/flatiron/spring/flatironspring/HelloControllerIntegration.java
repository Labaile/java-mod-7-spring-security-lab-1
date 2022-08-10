package com.flatiron.spring.flatironspring;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerIntegration {

    private JokeService jokeService;

    public HelloControllerIntegration(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "targetName", defaultValue = "Stephanie") String name) {
        String greeting = "Hello " + name;
        greeting += "<br/>";
        greeting += "Dad joke of the moment: " + jokeService.getDadJoke();
        return greeting;


//    @GetMapping("/hello")
//    public String hello(@RequestParam(name = "targetName", defaultValue = "Stephanie") String name) {
//        return String.format("Hello %s", name);
//    }

    }
}
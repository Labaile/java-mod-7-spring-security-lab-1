package com.flatiron.spring.flatironspring;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private JokeService jokeService;

    public HelloController(JokeService jokeService) {
        this.jokeService = jokeService;

    }
//TODO
//This means you have to update all your integration and acceptance tests to make them use the updated URLs -
// you should be able to do that on your own.
    @GetMapping("/api/hello")
    public String hello(@RequestParam(name = "targetName", defaultValue = "Stephanie") String name) {
        String greeting = "Hello " + name;
        greeting += "<br/>";
        greeting += "Dad joke of the moment: " + jokeService.getDadJoke();
        return greeting;
    }

    @GetMapping("/api/status")
    public String status() {
        return "Congratulations - you must be an admin since you can see the application's status information";
    }




    //@GetMapping("/hello")
   // public String hello(String name) {
     //   return String.format("Hello %s", name);

    //@GetMapping("/hello")
    //public String hello() {
      //  return "Hello World";
    }


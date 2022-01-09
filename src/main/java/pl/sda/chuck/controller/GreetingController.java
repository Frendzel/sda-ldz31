package pl.sda.chuck.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.chuck.dto.Greeting;

@RestController
public class GreetingController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "world";
    }
    @GetMapping(path = "/hello/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting helloJson() {
        return new Greeting("world");
    }

}

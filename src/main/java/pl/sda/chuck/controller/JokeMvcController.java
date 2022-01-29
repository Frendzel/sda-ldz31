package pl.sda.chuck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class JokeMvcController {

    @GetMapping("/view/joke")
    public String showJoke() {
        return "joke";
    }
}

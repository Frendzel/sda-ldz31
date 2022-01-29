package pl.sda.chuck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.service.JokeService;

@Controller
public class JokeMvcController {

    @Autowired
    JokeService jokeService;

    @GetMapping("/view/joke")
    public String showJoke(Model model) { // UI Model which is used to process data between layers (view & controller)
        Joke joke = jokeService.getRandomJoke().orElseThrow();
        model.addAttribute("joke", joke); // object joke put in map on key joke
        return "joke"; // html name, should match
    }
}

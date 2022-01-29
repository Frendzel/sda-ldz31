package pl.sda.chuck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.service.JokeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @GetMapping("/view/jokes")
    public String showJokes(Model model) {

        //for
//        List<Joke> jokes = new ArrayList<>();
//        for (int i=0; i<10; i++){
//            jokes.add(jokeService.getRandomJoke().orElseThrow());
//        }

        //IntStream
        List<Joke> jokes = IntStream.range(0, 10)
                .boxed()
                .map(integer -> jokeService.getRandomJoke().orElseThrow()).toList();


        model.addAttribute("jokes", jokes);
        return "joke-list"; // html name, should match
    }
}

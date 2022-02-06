package pl.sda.chuck.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.service.JokeService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Controller // Annotation used to handle mvc properly (methods are returning names of html templates)
@Slf4j
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

        //for alternative way
//        List<Joke> jokes = new ArrayList<>();
//        for (int i=0; i<10; i++){
//            jokes.add(jokeService.getRandomJoke().orElseThrow());
//        }

        //IntStream
        List<Joke> jokes = IntStream.range(0, 10)
                .boxed()
                .map(integer -> jokeService.getRandomJoke().orElseThrow())
                .collect(toList());


        model.addAttribute("jokes", jokes);
        return "joke-list"; // html name, should match
    }

    @GetMapping("/joke/view/add")
    public String formJoke(Model model) {
        model.addAttribute("joke", new Joke());
        return "joke-form";
    }

    //TODO add bindingResult support
    @PostMapping("/joke/view/add")
    public String saveJoke(@Valid @ModelAttribute Joke joke, final BindingResult bindingResult) {
        log.info("Joke to be saved: {}", joke);
        if (bindingResult.hasErrors()) {
            log.error("Form has below errors: ");
            bindingResult
                    .getAllErrors()
                    .forEach(objectError -> log.warn(objectError.toString()));
            return "joke-form";
        }
        jokeService.save(joke);
        return "success";
    }
}

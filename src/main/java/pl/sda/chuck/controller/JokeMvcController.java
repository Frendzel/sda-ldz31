package pl.sda.chuck.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.chuck.dao.BaseResponse;
import pl.sda.chuck.dao.RESPONSE_STATUS;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.service.JokeService;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Controller
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

        //for
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

    //TODO
    @PostMapping("/joke/view/add")
    public BaseResponse saveJoke(Joke joke, final BindingResult bindingResult) {
        log.info("Joke to be saved: {}", joke);
        jokeService.save(joke);
        return new BaseResponse(RESPONSE_STATUS.SUCCESS);
    }

    @GetMapping("/joke/view/add")
    public String viewAdd(Joke joke){
        return "joke-form";
    }

    @GetMapping("/view/form")
    public ModelAndView formJoke(Joke joke){
        ModelAndView mv = new ModelAndView("joke-form");
        mv.addObject("joke", new Joke());
        return mv;
    }
}

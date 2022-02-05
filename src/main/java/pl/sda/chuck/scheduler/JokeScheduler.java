package pl.sda.chuck.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.service.JokeService;

import java.util.Optional;

@Component
@Slf4j
public class JokeScheduler {

    @Autowired
    JokeService jokeService;

    @Scheduled(cron = "${joke.get.interval}") //Scheduler has been turned off
    public void schedule() {
        //TODO add thread ID
        log.info("Scheduler invoked");
        Optional<Joke> randomJoke = jokeService.getRandomJoke();
        randomJoke.ifPresent(joke -> jokeService.save(joke));
        log.info("Scheduler finished");
    }

}

package pl.sda.chuck.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pl.sda.chuck.dto.Joke;

@Component
@Slf4j
public class JokeConsumer {

    //TODO H2 Repository

    @JmsListener(destination = "messageBox")
    public void consume(Joke joke) {
        log.info("Consumed joke: {}", joke.toString());
    }
}

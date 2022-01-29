package pl.sda.chuck.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import pl.sda.chuck.dto.Joke;
import pl.sda.chuck.dto.JokeValue;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class JokeProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    //TODO MessageConverter

    @PostConstruct
    public void sendMessage() {
        jmsTemplate.convertAndSend(
                "messageBox",
                Joke.builder().type("SUCCESS").value(
                        JokeValue.builder()
                                .id(1)
                                .joke("Funny Joke")
                                .build()).build()
        );
        log.info("Joke has been sent!");
    }
}

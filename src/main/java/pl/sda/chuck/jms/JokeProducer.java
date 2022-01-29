package pl.sda.chuck.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class JokeProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    @PostConstruct
    public void sendMessage() {
        jmsTemplate.convertAndSend("messageBox", "Hello World");
        log.info("Joke has been sent!");
    }
}

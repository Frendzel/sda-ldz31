package pl.sda.chuck.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
@Slf4j
public class JokeConsumer {

    @JmsListener(destination = "messageBox")
    public void consume(Message message) {
        log.info("Consumed message: " + message.toString());
    }
}

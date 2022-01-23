package pl.sda.chuck.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.chuck.dto.Greeting;

@RestController
@Slf4j
public class GreetingController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "world";
    }

    @GetMapping(path = "/hello/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting helloJson() {
        return new Greeting("world");
    }

    @Async
    @GetMapping(path = "/long/answer")
    public void doAnswer() throws InterruptedException {
        veryComplicatedBusinessLogicToCalculateSalaryIn2022();
    }

    private void veryComplicatedBusinessLogicToCalculateSalaryIn2022() throws InterruptedException {
        Thread.sleep(Long.parseLong("5000"));
        log.info("Id of thread which is processing is: {}", Thread.currentThread().getId());
    }

}

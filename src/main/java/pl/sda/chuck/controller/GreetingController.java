package pl.sda.chuck.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.chuck.dto.Greeting;

import javax.validation.Valid;

import static java.lang.Thread.currentThread;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController // Annotation used to use controller only for rest methods (without web)
@Slf4j // Annotation used to turn on logging
@Validated // We need this annotation to enforce validation (using of @Valid annotation over methods)
public class GreetingController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "world";
    }

    /*
     * Valid annotation used to force validation of an endpoint
     * produces parameter pass information about target type (application json)
     * ResponseBody - bounding response body (used for serialization/deserialization)
     * Serialization ---> object to bytes
     * Deserialization ---> bytes to object
     */
    @Valid
    @GetMapping(path = "/hello/json", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody
    Greeting helloJson() {
        return new Greeting("HELLO");
    }

    @Async // Async annotation to get response immediately. In background an old thread is continuing calculations
    @GetMapping(path = "/long/answer")
    public void doAnswer() throws InterruptedException {
        veryComplicatedBusinessLogicToCalculateSalaryIn2022();
    }

    private void veryComplicatedBusinessLogicToCalculateSalaryIn2022() throws InterruptedException {
        Thread.sleep(Long.parseLong("5000")); //Simulation of long calculations
        log.info("Id of thread which is processing is: {}", currentThread().getId()); //Logging information for thread, his identifier
    }

}

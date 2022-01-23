package pl.sda.chuck;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import pl.sda.poli.A;
import pl.sda.poli.C;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
@ComponentScan("pl.sda")
public class ChuckJokesCollectorApplication implements CommandLineRunner {

    @Autowired
    ApplicationContext context;

    @Autowired
    A a;

    @Autowired
    C b;

    @Autowired
    @Qualifier("d")
    C c;

    public static void main(String[] args) {
        SpringApplication.run(ChuckJokesCollectorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        log.info("Hello, run with args: {}", args);
//        log.info("Before context beans definition");
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(s -> log.info("Name: {}", s));
//        a.printMyName();
//        b.printMyName();
//        log.trace("Before method on c object invocation");
//        c.printMyName();
//        log.trace("After method on c object invocation");
    }
}


















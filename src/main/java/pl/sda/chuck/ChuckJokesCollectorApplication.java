package pl.sda.chuck;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.sda.poli.A;
import pl.sda.poli.C;

@SpringBootApplication
@Slf4j
@ComponentScan("pl.sda")
@EnableScheduling
@EnableAspectJAutoProxy
@EnableAsync
@EnableJms
public class ChuckJokesCollectorApplication implements CommandLineRunner {

    @Autowired
    ApplicationContext context;

    @Value("${the.best.group.in.sda}")
    String sampleValue;

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
        log.info("Sample value: {}", sampleValue);
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


















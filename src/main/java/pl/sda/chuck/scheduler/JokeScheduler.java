package pl.sda.chuck.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JokeScheduler {

    @Scheduled(cron = "* * * * * *") //TODO extract to configuration
    public void schedule() {
        log.info("Scheduler invoked");
        //1.GetJoke
        //2.SaveJoke
        //3.Be sure that has been logged
    }

}

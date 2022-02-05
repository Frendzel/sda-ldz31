package pl.sda.chuck.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration // will be loaded as first
@Profile("!mocked-db")
@Slf4j
public class JokesH2Configuration {

    @PostConstruct
    public void log() {
        log.info("We're using h2 configuration");
    }

    //TODO Support H2 connfiguration via profile

}

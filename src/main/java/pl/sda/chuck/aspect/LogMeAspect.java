package pl.sda.chuck.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * We want to have aspect which will run before and after method invocation marked
 * using {@link LogMe}
 */
@Aspect
@Component
@Slf4j
public class LogMeAspect {

    @PostConstruct
    public void log() {
        log.info("Aspect properly invoked.");
    }

    @Before("@annotation(pl.sda.chuck.aspect.LogMe)")
    public void logMeBefore() {
        log.info("Before invocation: "
                + getClass().getSimpleName()
                + " by thread: "
                + Thread.currentThread());
    }

    @After("@annotation(pl.sda.chuck.aspect.LogMe)")
    public void logMeAfter() {
        log.info("After invocation: "
                + getClass().getSimpleName()
                + " by thread: "
                + Thread.currentThread());
    }
}

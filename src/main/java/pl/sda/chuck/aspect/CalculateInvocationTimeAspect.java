package pl.sda.chuck.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Aspect
@Component
@Slf4j
public class CalculateInvocationTimeAspect {

    @PostConstruct
    public void log() {
        log.info("Aspect properly invoked.");
    }

    @Around("@annotation(pl.sda.chuck.aspect.CalculateInvocationTime)")
    public Object calculate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed(); //method invocation
        long stop = System.currentTimeMillis();
        log.info("Method invocation time: {}", stop - start);
        return result;
    }
}

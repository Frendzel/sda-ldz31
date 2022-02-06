package pl.sda.chuck.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.chuck.aspect.CalculateInvocationTime;
import pl.sda.chuck.exception.ExternalTechnicalException;
import pl.sda.chuck.reports.Generator;
import pl.sda.chuck.reports.GeneratorType;
import pl.sda.chuck.reports.ReportFactory;
import pl.sda.chuck.service.JokeService;

@RestController
@Slf4j
public class ReportController {

    @Autowired
    ReportFactory reportFactory;

    @Autowired
    JokeService jokeService;

    /**
     * For example:
     * GET localhost:9090/report/PDF
     */
    @GetMapping("/report/{type}")
    @CalculateInvocationTime
    public void generateReport(@PathVariable String type) {
        log.trace("Generating report for given type: {}", type);
        generate(type);
    }

    /**
     * For example:
     * GET localhost:9090/report&type=PDF
     */
    @GetMapping("/report")
    @CalculateInvocationTime
    public void generateReport2(@RequestParam String type) {
        log.trace("Generating report for given type: {}", type);
        generate(type);
    }

    private void generate(String type) {
        try {
            Generator generator = reportFactory.createGenerator(GeneratorType.valueOf(type));
            generator.generate(jokeService.findAllJokes());
        } catch (Exception e) {
            log.error("Error happened: {}", e.getMessage());
            throw new ExternalTechnicalException(e.getMessage());
        }
    }
}

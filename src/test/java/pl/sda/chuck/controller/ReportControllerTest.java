package pl.sda.chuck.controller;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class ReportControllerTest {

    @Test
    public void test() {
        Class<ReportController> reportControllerClass = ReportController.class;
        for (Annotation annotation : reportControllerClass.getAnnotations()) {
            System.out.println(annotation.toString());
        }
        for (Method method : reportControllerClass.getMethods()) {
            for (Annotation annotation : method.getAnnotations()) {
                System.out.println(annotation);
            }
        }
    }

}
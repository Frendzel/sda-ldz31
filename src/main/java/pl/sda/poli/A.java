package pl.sda.poli;

import org.springframework.stereotype.Component;

@Component
public class A implements C {

    String status;

    public A() {
        this.status = "ACTIVE";
    }

    @Override
    public String getStatus() {
        return status;
    }
}

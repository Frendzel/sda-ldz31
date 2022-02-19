package pl.sda.poli;

import org.springframework.stereotype.Component;

@Component
public class D extends B {
    String status;

    public D() {
        this.status = "active";
    }

    @Override
    public String getStatus() {
        return status;
    }
}

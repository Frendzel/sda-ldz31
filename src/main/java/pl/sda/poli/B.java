package pl.sda.poli;

import org.springframework.stereotype.Component;

@Component
public class B implements C {

    String status;

    public B() {
        this.status = "active";
    }

    public String getStatus() {
        return status;
    }
}

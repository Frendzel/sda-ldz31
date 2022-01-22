package pl.sda.poli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Aggregator {

    private final A a;
    private final B b;
    private final D d;

    /**
     * We prefer to construct via constructor because testing will be easier.
     */
    @Autowired // optional, because Spring will create it automatically
    public Aggregator(A a, B b, D d) {
        this.a = a;
        this.b = b;
        this.d = d;
    }
}

package pl.sda.chuck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.poli.C;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ChuckJokesCollectorApplicationIntegrationTest {

    @Autowired
    C a;

    @Test
    @DisplayName("Class A status verification - positive")
    void contextLoadsTest() {
        //given [optional]

        //when
        String status = a.getStatus();
        //then
        assertEquals("ACTIVE", status);
    }

}

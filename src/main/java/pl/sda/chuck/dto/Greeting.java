package pl.sda.chuck.dto;

import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Greeting {

    @NotBlank
    String value;

    public Greeting() {
    }

    public Greeting(String value) {
        this.value = value;
    }
}

package pl.sda.chuck.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class Greeting {
    @NonNull
    String value;
}

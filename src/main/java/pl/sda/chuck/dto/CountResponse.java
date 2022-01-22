package pl.sda.chuck.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Example:
 * { "type": "success", "value": <count> }
 */
@Data
@NoArgsConstructor //jackson library
public class CountResponse {
    @NonNull
    String type;
    @NonNull
    Integer value;
}

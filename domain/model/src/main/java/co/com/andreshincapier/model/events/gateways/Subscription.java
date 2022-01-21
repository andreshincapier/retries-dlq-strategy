package co.com.andreshincapier.model.events.gateways;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Subscription implements Serializable {

    private int id;
    private String name;
    private String enterprise;

    public static final String COMMAND_NAME = "subscriptions.subscribe";
}

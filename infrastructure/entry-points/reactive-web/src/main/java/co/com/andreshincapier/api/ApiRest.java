package co.com.andreshincapier.api;

import co.com.andreshincapier.model.events.gateways.Subscription;
import co.com.andreshincapier.usecase.SubscriptionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final SubscriptionUseCase subscriptionUseCase;

    @PostMapping(path = "/subscription")
    public Mono<Void> commandName(@RequestBody SubscriptionDTO subscriptionDTO) {

        Subscription subscription = Subscription.builder()
            .id(subscriptionDTO.getId())
            .name(subscriptionDTO.getName())
            .enterprise(subscriptionDTO.getEnterprise())
            .build();

        return subscriptionUseCase.subscribe(subscription);
    }
}

package co.com.andreshincapier.api;

import co.com.andreshincapier.model.events.Subscription;
import co.com.andreshincapier.usecase.SubscriptionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final SubscriptionUseCase subscriptionUseCase;

    @PostMapping("/subscribe")
    public Mono<Void> subscribe(@RequestBody SubscriptionDTO dto) {
        Subscription subscription = Subscription.builder()
            .id(dto.getId())
            .name(dto.getName())
            .enterprise(dto.getEnterprise())
            .build();
        return subscriptionUseCase.subscribe(subscription);
    }
}

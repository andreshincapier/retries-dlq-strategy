package co.com.andreshincapier.restservice;

import co.com.andreshincapier.model.events.Subscription;
import co.com.andreshincapier.model.events.gateways.SubscriptionGateway;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class APISubscription implements SubscriptionGateway {

    @Override
    public Mono<Void> subscribeEnterpriseAsync(Subscription subscription) {
        //TODO Simulate http request
        return Mono.error(new Error("Im fails im sorry"));
    }
}

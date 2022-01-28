package co.com.andreshincapier.model.events.gateways;

import reactor.core.publisher.Mono;

public interface DiscardGateway {

    Mono<String> discardSubscription(Subscription subscription);
}

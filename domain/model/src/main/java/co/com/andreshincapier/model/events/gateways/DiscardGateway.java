package co.com.andreshincapier.model.events.gateways;

import reactor.core.publisher.Mono;

public interface DiscardGateway {

    Mono<Void> discardSubscription(Subscription subscription);

}

package co.com.andreshincapier.usecase;

import co.com.andreshincapier.model.events.gateways.DiscardGateway;
import co.com.andreshincapier.model.events.gateways.Subscription;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DiscardSubscriptionUseCase {

    private final DiscardGateway discardGateway;

    public Mono<Void> notifyDiscard(Subscription subscription) {
        return discardGateway.discardSubscription(subscription)
            .then();
    }
}

package co.com.andreshincapier.usecase;


import co.com.andreshincapier.model.events.gateways.EventGateway;
import co.com.andreshincapier.model.events.gateways.Subscription;
import co.com.andreshincapier.model.events.gateways.SubscriptionGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AsyncSubscriptionsUseCase {

    private final SubscriptionGateway subscriptionGateway;
    private final EventGateway eventGateway;

    public Mono<Void> subscribeEnterprise(Subscription subscription) {
        return subscriptionGateway.subscribeEnterpriseAsync(subscription)
            .then(eventGateway.emitEvent("!!! Success message !!!"));
    }
}

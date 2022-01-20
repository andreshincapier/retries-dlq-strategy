package co.com.andreshincapier.usecase;

import co.com.andreshincapier.model.events.Subscription;
import co.com.andreshincapier.model.events.gateways.EventsGateway;
import co.com.andreshincapier.model.events.gateways.SubscriptionGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AsyncSubscriptionsUseCase {

    private final SubscriptionGateway subscriptionGateway;
    private final EventsGateway eventsGateway;

    public Mono<Void> subscribeEnterprise(Subscription subscription) {
        return subscriptionGateway.subscribeEnterpriseAsync(subscription)
            .then(eventsGateway.emitEvent("Success message!!!"));
    }
}

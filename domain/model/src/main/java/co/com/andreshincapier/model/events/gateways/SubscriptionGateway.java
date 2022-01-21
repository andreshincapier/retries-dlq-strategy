package co.com.andreshincapier.model.events.gateways;

import reactor.core.publisher.Mono;

public interface SubscriptionGateway {

    Mono<Void> subscribeEnterpriseAsync(Subscription subscription);

}

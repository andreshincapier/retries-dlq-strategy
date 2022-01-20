package co.com.andreshincapier.model.events.gateways;

import co.com.andreshincapier.model.events.Subscription;
import reactor.core.publisher.Mono;

public interface SubscriptionGateway {

    Mono<Void> subscribeEnterpriseAsync(Subscription subscription);
}

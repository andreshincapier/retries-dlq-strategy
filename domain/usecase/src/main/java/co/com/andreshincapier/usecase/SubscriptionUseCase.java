package co.com.andreshincapier.usecase;

import co.com.andreshincapier.model.events.Subscription;
import co.com.andreshincapier.model.events.gateways.CommandGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SubscriptionUseCase {

    private final CommandGateway commandGateway;

    public Mono<Void> subscribe(Subscription subscription) {
        return commandGateway.emitCommand(subscription);
    }
}

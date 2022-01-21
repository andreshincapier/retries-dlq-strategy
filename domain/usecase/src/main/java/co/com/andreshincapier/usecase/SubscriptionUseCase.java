package co.com.andreshincapier.usecase;


import co.com.andreshincapier.model.events.gateways.CommandGateway;
import co.com.andreshincapier.model.events.gateways.Subscription;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SubscriptionUseCase {

    private final CommandGateway commandGateway;

    public Mono<Void> subscribe(Subscription subscription) {
        return commandGateway.emitCommand(subscription);
    }
}

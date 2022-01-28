package co.com.andreshincapier.usecase;


import co.com.andreshincapier.model.events.gateways.CommandGateway;
import co.com.andreshincapier.model.events.gateways.DiscardGateway;
import co.com.andreshincapier.model.events.gateways.Subscription;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SubscriptionUseCase {

    private final CommandGateway commandGateway;
    private final DiscardGateway discardGateway;

    public Mono<Void> subscribe(Subscription subscription) {
        return discardGateway.discardSubscription(subscription).then();
//        return commandGateway.emitCommand(subscription);
    }
}

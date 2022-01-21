package co.com.andreshincapier.model.events.gateways;

import reactor.core.publisher.Mono;

public interface CommandGateway {

    Mono<Void> emitCommand(Subscription subscription);
}

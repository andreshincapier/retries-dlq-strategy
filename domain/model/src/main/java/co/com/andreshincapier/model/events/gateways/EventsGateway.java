package co.com.andreshincapier.model.events.gateways;

import reactor.core.publisher.Mono;

public interface EventsGateway {

    Mono<Void> emitEvent(String message);
}

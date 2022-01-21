package co.com.andreshincapier.model.events.gateways;

import reactor.core.publisher.Mono;

public interface EventGateway {

    Mono<Void> emitEvent(String message);

}

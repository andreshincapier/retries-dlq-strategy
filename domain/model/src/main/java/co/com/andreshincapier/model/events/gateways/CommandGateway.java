package co.com.andreshincapier.model.events.gateways;

import co.com.andreshincapier.model.events.Subscription;
import reactor.core.publisher.Mono;

public interface CommandGateway {

    Mono<Void> emitCommand(Subscription event);

}

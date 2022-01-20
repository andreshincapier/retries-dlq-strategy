package co.com.andreshincapier.events;

import static java.util.UUID.randomUUID;

import co.com.andreshincapier.model.events.gateways.EventsGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Log
@RequiredArgsConstructor
@Component
@EnableDirectAsyncGateway
public class ReactiveEmitGateway implements EventsGateway {

    private final DomainEventBus domainEventBus;

    @Override
    public Mono<Void> emitEvent(String message) {
        DomainEvent<String> domainEvent = new DomainEvent<>("event.notification", randomUUID().toString(), message);
        return Mono.from(domainEventBus.emit(domainEvent));
    }
}

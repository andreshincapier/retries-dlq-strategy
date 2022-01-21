package co.com.andreshincapier.events;

import co.com.andreshincapier.model.events.gateways.EventGateway;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Log
@Component
@RequiredArgsConstructor
@EnableDirectAsyncGateway
public class ReactiveEmitGateway implements EventGateway {

    public final DomainEventBus domainEventBus;

    @Override
    public Mono<Void> emitEvent(String message) {
        DomainEvent<String> domainEvent = new DomainEvent<>("event.notification", UUID.randomUUID().toString(), message);
        return Mono.from(domainEventBus.emit(domainEvent));
    }
}

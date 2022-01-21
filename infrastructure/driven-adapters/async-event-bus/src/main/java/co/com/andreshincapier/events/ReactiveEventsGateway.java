package co.com.andreshincapier.events;

import static java.util.logging.Level.INFO;

import co.com.andreshincapier.model.events.gateways.CommandGateway;
import co.com.andreshincapier.model.events.gateways.Subscription;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import reactor.core.publisher.Mono;

@Log
@RequiredArgsConstructor
@EnableDomainEventBus
public class ReactiveEventsGateway implements CommandGateway {

    private final DirectAsyncGateway asyncGateway;
    private static final String TARGET = "retries-dlq-strategy";

    @Override
    public Mono<Void> emitCommand(Subscription subscription) {
        log.log(INFO, "ReactiveEventsGateway::emitCommand {0}", subscription.toString());

        String uuid = UUID.randomUUID().toString();
        return asyncGateway.sendCommand(new Command<>("subscriptions.subscribe", uuid, subscription), TARGET);
    }
}

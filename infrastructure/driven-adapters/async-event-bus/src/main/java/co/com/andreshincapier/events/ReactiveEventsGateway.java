package co.com.andreshincapier.events;

import co.com.andreshincapier.model.events.Subscription;
import co.com.andreshincapier.model.events.gateways.CommandGateway;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Log
@Component
@EnableDirectAsyncGateway
@RequiredArgsConstructor
public class ReactiveEventsGateway implements CommandGateway {

    private final DirectAsyncGateway directAsyncGateway;
    private static final String TARGET = "retries-dlq-strategy";

    @Override
    public Mono<Void> emitCommand(Subscription sub) {
        String uuid = UUID.randomUUID().toString();
        return directAsyncGateway.sendCommand(new Command<>("subscriptions.subscribe", uuid, sub), TARGET);
    }

}

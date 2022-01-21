package co.com.andreshincapier.dynamodbfallback;

import static java.util.logging.Level.INFO;

import co.com.andreshincapier.model.events.gateways.DiscardGateway;
import co.com.andreshincapier.model.events.gateways.Subscription;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Log
@Component
public class DynamoFallback implements DiscardGateway {

    @Override
    public Mono<Void> discardSubscription(Subscription subscription) {
        //Dynamodb logic to save subscription
        log.log(INFO, "DynamoFallback::discardSubscription {0}", subscription);
        return Mono.empty();
    }
}

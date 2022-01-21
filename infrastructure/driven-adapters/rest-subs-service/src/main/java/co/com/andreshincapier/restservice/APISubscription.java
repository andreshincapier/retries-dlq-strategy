package co.com.andreshincapier.restservice;

import static java.util.logging.Level.INFO;

import co.com.andreshincapier.model.events.gateways.Subscription;
import co.com.andreshincapier.model.events.gateways.SubscriptionGateway;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Log
@Component
public class APISubscription implements SubscriptionGateway {

    @Override
    public Mono<Void> subscribeEnterpriseAsync(Subscription subscription) {
        //Simulate HTTP request
        log.log(INFO, "APISubscription::subscribeEnterpriseAsync {0}", subscription.toString());

        return Mono.empty();
//        return Mono.error(new Error("Sorry the service has been fail !!!"));
    }
}

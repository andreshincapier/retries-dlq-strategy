package co.com.andreshincapier.config;

import co.com.andreshincapier.model.events.gateways.CommandGateway;
import co.com.andreshincapier.model.events.gateways.EventsGateway;
import co.com.andreshincapier.model.events.gateways.SubscriptionGateway;
import co.com.andreshincapier.usecase.AsyncSubscriptionsUseCase;
import co.com.andreshincapier.usecase.SubscriptionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

    @Bean
    public AsyncSubscriptionsUseCase asyncSubscriptionsUseCase(SubscriptionGateway sub,
        EventsGateway event) {
        return new AsyncSubscriptionsUseCase(sub, event);
    }

    @Bean
    public SubscriptionUseCase subscriptionUseCase(CommandGateway commandGateway) {
        return new SubscriptionUseCase(commandGateway);
    }
}

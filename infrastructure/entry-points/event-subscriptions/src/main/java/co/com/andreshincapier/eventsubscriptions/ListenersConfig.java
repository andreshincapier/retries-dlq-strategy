package co.com.andreshincapier.eventsubscriptions;

import static org.reactivecommons.async.api.HandlerRegistry.register;

import co.com.andreshincapier.model.events.gateways.Subscription;
import co.com.andreshincapier.usecase.AsyncSubscriptionsUseCase;
import co.com.andreshincapier.usecase.DiscardSubscriptionUseCase;
import co.com.andreshincapier.usecase.NotificationUseCase;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.api.HandlerRegistry;
import org.reactivecommons.async.impl.config.annotations.EnableCommandListeners;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@EnableCommandListeners
@Configuration
@RequiredArgsConstructor
public class ListenersConfig {

    private final AsyncSubscriptionsUseCase asyncSubscriptionsUseCase;
    private final DiscardSubscriptionUseCase discardSubscriptionUseCase;
    private final NotificationUseCase notificationUseCase;

    @Bean
    public HandlerRegistry handleEventSubscriptions() {
        return register()
            .handleCommand(Subscription.COMMAND_NAME, this::handleSubscription, Subscription.class)
            .listenEvent(Subscription.COMMAND_NAME + ".dlq", this::handleDiscard,
                Subscription.class);
//            .listenEvent("event.notification", this::sendNotification, String.class);
    }

    private Mono<Void> sendNotification(DomainEvent<String> message) {
        return notificationUseCase.sendNotification(message.getData());
    }

    private Mono<Void> handleSubscription(Command<Subscription> command) {
        return asyncSubscriptionsUseCase.subscribeEnterprise(command.getData());
    }

    private Mono<Void> handleDiscard(DomainEvent<Subscription> subsEvent) {
        return discardSubscriptionUseCase.notifyDiscard(subsEvent.getData());
    }

}

package co.com.andreshincapier.usecase;

import co.com.andreshincapier.model.notificatios.gateways.NotificationGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class NotificationUseCase {

    private final NotificationGateway notificationGateway;

    public Mono<Void> sendNotification(String message) {
        return notificationGateway.sendNotification(message);
    }
}

package co.com.andreshincapier.notification.sender;

import static java.util.logging.Level.INFO;

import co.com.andreshincapier.model.notificatios.gateways.NotificationGateway;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Log
@Service
@NoArgsConstructor
public class NotificationSenderAdapter implements NotificationGateway {

    @Override
    public Mono<Void> sendNotification(String message) {
        //Implements SMS or Email notification
        log.log(INFO, "NotificationSenderAdapter::sendNotification {0}", message);
        return Mono.empty();
    }
}

package co.com.andreshincapier.mq.listener;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SampleMQMessageListener {
    // private final SampleUseCase useCase;

    // For fixed queues
//    @MQListener
//    public Mono<Void> process(Message message) throws JMSException {
//        String text = ((TextMessage) message).getText();
        // return useCase.sample(text);
//        return Mono.empty();
//    }

    // For an automatic generated temporary queue
    // @MQListener(tempQueueAlias = "any-custom-value")
    // public Mono<Void> processFromTemporaryQueue(Message message) throws JMSException {
    //     String text = ((TextMessage) message).getText();
    //     // return useCase.sample(text);
    //     return Mono.empty();
    // }
}

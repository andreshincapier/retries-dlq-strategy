package co.com.andreshincapier.dynamodbfallback;

import co.com.andreshincapier.model.events.gateways.DiscardGateway;
import co.com.andreshincapier.model.events.gateways.Subscription;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

@Slf4j
@Component
public class DynamoFallback implements DiscardGateway {

    private final DynamoDbAsyncClient dynamoDbAsyncClient;
    private final String tableName;

    public DynamoFallback(DynamoDbAsyncClient dynamoDbAsyncClient,
        @Value("${application.dynamo.customer-table-name}") String tableName) {
        this.dynamoDbAsyncClient = dynamoDbAsyncClient;
        this.tableName = tableName;
    }

    @Override
    public Mono<String> discardSubscription(Subscription sub) {

        PutItemRequest putItemRequest = PutItemRequest.builder().item(
                Map.of("customerId", AttributeValue.builder().s(String.valueOf(sub.getId())).build(),
                    "emailAddress", AttributeValue.builder().s(sub.getName()).build())
            )
            .tableName(tableName).build();

        return Mono.fromFuture(dynamoDbAsyncClient.putItem(putItemRequest))
            .thenReturn("save data")
            .doOnError(throwable -> log.info("algo {}", throwable.getMessage()));
    }
}

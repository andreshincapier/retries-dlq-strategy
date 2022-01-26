package co.com.andreshincapier.dynamodbfallback;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

@Repository
public class DynamoRepository {

    private DynamoDbAsyncClient dynamoDbAsyncClient;
    private final String customerTableName;

    public DynamoRepository(
        @Value("${application.dynamo.customer-table-name}") String customerTableName) {
        this.customerTableName = customerTableName;
    }
}

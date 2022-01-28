### Dynamodb configurations

```bash
aws dynamodb --endpoint-url http://localhost:8000 create-table --table-name demo-customer-info \
--attribute-definitions AttributeName=id,AttributeType=S --key-schema AttributeName=name,KeyType=HASH \
--provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5
```
## Test order creation flow

curl -X 'POST' \
  'http://localhost:8051/orders' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "customerId": "uuid-4898asd4f-adf554887",
  "orderLines": [
    {
      "itemId": "string",
      "quantity": 1
    }
  ],
  "shippingAddress": {
    "line1": "string",
    "line2": "string",
    "city": "string",
    "county": "string",
    "postcode": "string",
    "country": "string"
  },
  "billingAddress": {
    "line1": "string",
    "line2": "string",
    "city": "string",
    "county": "string",
    "postcode": "string",
    "country": "string"
  },
  "paymentDetails": {
    "cardType": "string",
    "nameOnCard": "string",
    "cardNumber": "4027041084796",
    "cvv": 999,
    "expires": "1237"
  }
}'
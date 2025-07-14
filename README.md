# Sample Error Responses

## Product Not Found Exception Response

```json
{
"status": "NOT_FOUND",
"errorType": "ProductNotFoundException",
"timestamp": "2025/07/14 10:39:43",
"detailedMessage": "Product is not found by id 234"
}
```

## Invalid Product Exception Response

```json
{
    "status": "BAD_REQUEST",
    "errorType": "InvalidProductException",
    "timestamp": "2025/07/14 10:37:41",
    "detailedMessage": "Product name cannot be null. , Maximum price should be up to 10 digit and 2 fraction. , Id should be up to 6 digits."
}
```

## Customer Not Found Exception Response

```json
{
  "status": "NOT_FOUND",
  "errorType": "CustomerNotFoundException",
  "timestamp": "2025/07/14 10:44:43",
  "detailedMessage": "Customer is not found by id 235"
}
```

## Invalid Customer Exception Response

```json
{
  "status": "BAD_REQUEST",
  "errorType": "InvalidCustomerException",
  "timestamp": "2025/07/14 10:43:08",
  "detailedMessage": "Customer email is invalid."
}
```

## Fall Back Exception Response
```json
{
"status": "INTERNAL_SERVER_ERROR",
"errorType": "HttpRequestMethodNotSupportedException",
"timestamp": "2025/07/14 11:14:26",
"detailedMessage": "Request method 'POST' is not supported"
}
```


# ServicePlanPriceChange

Design/ Class/ Sequence Diagram available on https://github.com/sowjiashok/ServicePlanPriceChange/wiki

Open as Maven project or go to the following folder on terminal: ServicePlanPriceChange/gs-rest-service/complete

RUNNING APPLICATION: Now, the API's can be run by running this command: mvn spring-boot:run.
LOGGING: Logging can be viewed on the terminal, by running http://localhost:8080/ on the browser.

The Netflix Pricing Subscription allows to update the price as per given Country, Service Plan and New Price using the following API:

1. POST http://localhost:8080/v1/subscription-pricing

Test cases:

1. Example:

JSON Request:
	{
            "serviceDescription": "1S",
            "priceChangeAmt": "12.00",
            "customerCountry": "India"
	}

JSON Response:
	{
    "countryServiceId": 8,
    "countryCode": "IN",
    "serviceId": 1,
    "updatedPrice": 840
	}
	
2. Edge Case Example - Invalid serviceDescription
	
JSON Request:
{
            "serviceDescription": "5SDec",
            "priceChangeAmt": "13.00",
            "customerCountry": "Canada"
}

or JSON Request::

{
            "serviceDescription": "",
            "priceChangeAmt": "15.00",
            "customerCountry": "Syria"
}
or JSON Request:
{
            "serviceDescription": "1",
            "priceChangeAmt": "15.00",
            "customerCountry": "Syria"
}
	
JSON Response: 
{
    "timestamp": "2018-11-25T09:36:10.409+0000",
    "status": 400,
    "error": "Bad Request",
    "errors": [
        {
            "codes": [
                "Invalid Service Description.updatePriceBasedOnCountryRequest.serviceDescription",
                "Invalid Service Description.serviceDescription",
                "Invalid Service Description.java.lang.String",
                "Invalid Service Description"
            ],
            "arguments": null,
            "defaultMessage": "9001",
            "objectName": "updatePriceBasedOnCountryRequest",
            "field": "serviceDescription",
            "rejectedValue": "1SS",
            "bindingFailure": false,
            "code": "Invalid Service Description"
        }
    ],
    "message": "Validation failed for object='updatePriceBasedOnCountryRequest'. Error count: 1",
    "path": "/v1/subscription-pricing"
}
3. Edge Case Example - Invalid priceChangeAmt 

JSON Request:
{
            "serviceDescription": "4S",
            "priceChangeAmt": "153435454.00",
            "customerCountry": "Canada"
}
JSON Response: 
{
    "timestamp": "2018-11-25T09:15:03.798+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "updatePricingBasedOnCountry.updatePriceBasedOnCountryRequest.priceChangeAmt: numeric value out of bounds (<5 digits>.<2 digits> expected)",
    "path": "/v1/subscription-pricing"
}

4. Edge Case Example - Empty/ Null priceChangeAmt 
JSON Request:
{
            "serviceDescription": "4S",
            "priceChangeAmt": "",
            "customerCountry": "Canada"
}

JSON Response:

{
    "timestamp": "2018-11-25T09:37:41.553+0000",
    "status": 400,
    "error": "Bad Request",
    "errors": [
        {
            "codes": [
                "Invalid Price Change.updatePriceBasedOnCountryRequest.priceChangeAmt",
                "Invalid Price Change.priceChangeAmt",
                "Invalid Price Change.java.math.BigDecimal",
                "Invalid Price Change"
            ],
            "arguments": null,
            "defaultMessage": "9002",
            "objectName": "updatePriceBasedOnCountryRequest",
            "field": "priceChangeAmt",
            "rejectedValue": null,
            "bindingFailure": false,
            "code": "Invalid Price Change"
        }
    ],
    "message": "Validation failed for object='updatePriceBasedOnCountryRequest'. Error count: 1",
    "path": "/v1/subscription-pricing"
}

5. Edge Case Example - Invalid priceChangeAmt
JSON Request:
{
            "serviceDescription": "1S",
            "priceChangeAmt": "2323fdfd",
            "customerCountry": "Canada"
}
JSON Response: 
{
    "timestamp": "2018-11-25T09:39:07.817+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "JSON parse error: Cannot deserialize value of type `java.math.BigDecimal` from String \"2323fdfd\": not a valid representation; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `java.math.BigDecimal` from String \"2323fdfd\": not a valid representation\n at [Source: (PushbackInputStream); line: 3, column: 31] (through reference chain: com.model.UpdatePriceBasedOnCountryRequest[\"priceChangeAmt\"])",
    "path": "/v1/subscription-pricing"
}

6. Edge Case Example - Invalid customerCountry
JSON Request:
{
            "serviceDescription": "4S",
            "priceChangeAmt": "153435454.00",
            "customerCountry": "Syria"
}
JSON Response: 
{
    "timestamp": "2018-11-25T09:16:19.900+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Incorrect result size: expected 1, actual 0",
    "path": "/v1/subscription-pricing"
}
- Currently the logic, is that customerCountry needs to be present in Country table. (Improvement: Cache this Country data, and check against cache data instead of making a DB call).

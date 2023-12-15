## Description:

Inventory management is essential for any sales business. In today's digital age, having a robust API-first approach ensures scalability, integration with other systems, and provides a foundation for future digital products.

## Business Requirements:

1. **Supply API**:

   Create an API endpoint to handle the addition of products to the inventory.

   **Feature Details**:
  - Endpoint: `/api/supply`
  - Method: `POST`
  - Payload should include product code, quantity, and optionally, an expiration date for perishable goods.
  - The maximum quantity that can be added in a single operation is 500 units.

2. **Sale API**:

   Create an API endpoint to handle the sale of products.

   **Feature Details**:
  - Endpoint: `/api/sale`
  - Method: `POST`
  - Payload should include product code and quantity.
  - Ensure products are in stock before confirming the sale.

3. **Product Return API**:

   Handle the return of products.

   **Feature Details**:
  - Endpoint: `/api/return`
  - Method: `POST`
  - Payload should include product code, quantity, and reason for return.
  - Returned products should be added back to the stock.

4. **Product Expiry Tracking API**:

   Track and fetch products nearing their expiration date.

   **Feature Details**:
  - Endpoint: `/api/expiry-alerts`
  - Method: `GET`
  - This endpoint should return a list of products nearing their expiration date.

5. **Inventory Threshold Alerts API**:

   Set thresholds and fetch products below the threshold.

   **Feature Details**:
  - Endpoint: `/api/threshold-alerts`
  - Method: `GET`
  - This endpoint should return products below their set threshold.
  - Endpoint: `/api/set-threshold`
  - Method: `POST`
  - Payload should include product code and threshold quantity.

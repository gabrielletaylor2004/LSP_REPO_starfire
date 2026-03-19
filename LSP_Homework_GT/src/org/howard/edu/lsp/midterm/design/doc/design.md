CRC Card
Class: Customer

Responsibilities:
- Stores customer information such as name and email
- Provides controlled access to customer data
- Represents the customer associated with an order

Collaborators:
- Order



CRC Card
Class: Order

Responsibilities:
- Stores order details such as item and price
- Associates an order with a customer
- Maintains calculated values such as tax, discount, and final total
- Represents the core business object in the system

Collaborators:
- Customer
- PricingService
- Receipt



CRC Card
Class: PricingService

Responsibilities:
- Calculates tax for an order
- Applies discount rules when appropriate
- Computes the final total in the correct order
- Centralizes pricing-related business logic

Collaborators:
- Order



CRC Cards
Class: Receipt

Responsibilities:
- Formats receipt information for display
- Represents a summary of the processed order
- Provides clean output of customer, item, tax, discount, and total information

Collaborators:
- Order



CRC Card
Class: OrderRepository

Responsibilities:
- Saves processed order information
- Handles persistence details such as writing to a file or database
- Isolates storage behaviour from business logic

Collaborators:
- Order



CRC Card
Class: EmailService

Responsibilities:
- Sends order confirmation messages to customers
- Uses customer contact information without storing business logic
- Keeps notification behaviour separate from order calculation

Collaborators (if any):
- Customer
- Order



CRC Cards
Class: LoggerService

Responsibilities:
- Records the time and status of order processing
- Centralizes logging behavior
- Supports future changes to logging format or destination

Collaborators:
- OrderProcessingService



CRC Cards
Class: OrderProcessingService

Responsibilities:
- Coordinates the steps of processing an order
- Requests pricing calculations
- Generates a receipt
- Saves the processed order
- Triggers confirmation email sending
- Triggers logging after processing is complete

Collaborators:
- Order
- PricingService
- Receipt
- OrderRepository
- EmailService
- LoggerService
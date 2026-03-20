## CRC Card 1
Class: OrderData

Responsibilities:
- Store order information such as customer name, email, item, and price
- Provide order details to other classes during processing
- Represent the core order data in the system

Collaborators:
- None

---

## CRC Card 2
Class: TaxCalculator

Responsibilities:
- Calculate tax for an order
- Return the tax amount based on the order price
- Keep tax calculation separate from other processing tasks

Collaborators:
- OrderData

---

## CRC Card 3
Class: ReceiptPrinter

Responsibilities:
- Print the order receipt
- Display customer and order details
- Show tax, discount, and final total on the receipt

Collaborators:
- OrderData
- TaxCalculator
- DiscountCalculator

---

## CRC Card 4
Class: FileSaver

Responsibilities:
- Save order information to a file
- Write processed order details in persistent storage
- Keep file handling separate from business logic

Collaborators:
- OrderData

---

## CRC Card 5
Class: EmailSender

Responsibilities:
- Send a confirmation email to the customer
- Use order details to generate the confirmation message
- Keep email functionality separate from order processing logic

Collaborators:
- OrderData

---

## CRC Card 6
Class: DiscountCalculator

Responsibilities:
- Apply discount rules to an order
- Determine whether a discount should be applied
- Return the updated total after discount calculation

Collaborators:
- OrderData

---

## CRC Card 7
Class: ActivityLogger

Responsibilities:
- Log order processing activity
- Record when an order has been processed
- Keep logging separate from order and pricing logic

Collaborators:
- OrderData
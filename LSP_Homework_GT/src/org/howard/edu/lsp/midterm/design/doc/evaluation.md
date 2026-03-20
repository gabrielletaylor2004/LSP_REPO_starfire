# Design Evaluation of OrderProcessor

The `OrderProcessor` class has several object-oriented design issues that negatively affect maintainability, extensibility, and clarity. The primary problem is that it violates the Single Responsibility Principle, as it handles multiple unrelated tasks within a single class. These responsibilities include storing order data, calculating tax, applying discounts, printing receipts, saving data to a file, sending confirmation emails, and logging activity. This results in low cohesion because the class is responsible for too many distinct behaviors.

The design also demonstrates high coupling. The class directly depends on multiple implementation details such as file handling, console output, and email logic. Because these operations are embedded within the same class, any change to storage format, output method, or notification system would require modifying the `OrderProcessor`, making the system difficult to extend.

Another issue is poor encapsulation. The fields `customerName`, `email`, `item`, and `price` are public, which allows unrestricted access and modification from outside the class. This increases the risk of invalid data and reduces control over the internal state of the object. Proper design would restrict access using private fields and controlled methods.

The `processOrder()` method further contributes to poor design by combining multiple responsibilities into one long procedure. This reduces readability and makes debugging more difficult, as errors in tax calculation, discount logic, file writing, or logging are all handled in the same place.

Additionally, the class violates the Open-Closed Principle. Adding new features, such as a new discount rule or different output format, requires modifying existing code rather than extending the system through new components. This increases the likelihood of introducing errors into stable functionality.

The design also lacks proper abstraction. Key behaviors such as tax calculation, discount application, receipt generation, file storage, email communication, and logging are not modeled as separate objects. Instead, they are implemented procedurally within one class, limiting flexibility and reusability.

A better design would separate these responsibilities into dedicated classes: `OrderData`, `TaxCalculator`, `DiscountCalculator`, `ReceiptPrinter`, `FileSaver`, `EmailSender`, and `ActivityLogger`. Each class would have a single, well-defined responsibility and would only collaborate with other classes when necessary. This improves cohesion, reduces coupling, strengthens encapsulation, and makes the system easier to maintain and extend.

Overall, the current design is functional but not scalable. By distributing responsibilities across focused classes and minimizing unnecessary dependencies, the system becomes more modular, flexible, and aligned with object-oriented design principles.
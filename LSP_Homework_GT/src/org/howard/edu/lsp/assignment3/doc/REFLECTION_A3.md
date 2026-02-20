# Assignment 3 Reflection
Gabrielle Taylor  
CSCI 363  

In Assignment 2, the ETL pipeline was implemented as a single class containing all logic inside the main method. File reading, data validation, transformation rules, and output writing were all handled within one large block of code. While the program worked correctly, the design was procedural and tightly coupled, making it harder to extend or maintain. In Assignment 3, the program was redesigned using object-oriented principles. Responsibilities were separated into multiple classes with clear purposes:

- Product represents the data model.
- ProductTransformer handles all business transformation rules.
- ETLProcessor coordinates file input/output and delegates transformation work.
- ETLPipelineApp serves as the application entry point.

Each class now has a single responsibility, making the system easier to test and extend.

The object-oriented concepts that were used are classes, objects, encapsulation, separation of concerns, and modularity. The Product class models a real-world entity. Each row in the CSV file becomes a Product object, making the code more intuitive and structured.All Product fields are private and accessed through public getters and setters. This protects internal state and ensures controlled modification of data. Transformation logic was moved into ProductTransformer, separating business rules from file processing logic in ETLProcessor.Each class performs a specific role, allowing future enhancements (such as additional transformations) without modifying unrelated code. Although inheritance and polymorphism were not heavily required in this assignment, the design allows future extension. For example, ProductTransformer could be replaced with different transformation strategies if needed.

To ensure Assignment 3 produced identical results to Assignment 2, I performed the following tests:

1. Normal input file — Verified transformed output matches Assignment 2 exactly.
2. Empty input file — Confirmed header-only output and correct row summary.
3. Missing input file — Confirmed graceful error handling without stack trace.

The console output, number of rows transformed, skipped rows, and final CSV content were identical between both implementations.
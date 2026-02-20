# AI Prompts – Assignment 3
Gabrielle Taylor  
CSCI 363  

---

## Prompt 1
"(uploaded Assignment 2 code)"
"How can I redesign this ETL pipeline to make it more object-oriented while preserving exact functionality? (same inputs, same outputs, same transformations, same error handling, and same relative paths)"

Summary of AI Response:
The AI suggested separating responsibilities into multiple classes:
- A Product class to represent data.
- A Transformer class for business logic.
- A Processor class for file handling.
- A main application class to start execution.

I adopted this structure.

---

## Prompt 2
"Generate and include Javadocs for each class and all public methods"

Summary:
The AI generated detailed Javadocs for all public classes and methods. I reviewed and edited them to ensure they accurately describe program behavior.

---

## Prompt 3
"What responsibilities should each class have in an object-oriented ETL design?"

Summary of AI Response:
The AI explained the concept of single responsibility principle and suggested that:
- The data class should only store and manage data.
- The transformer should only apply business rules.
- The processor should handle file operations.
- The main class should only start execution.

This helped clarify how to decompose the original large class into smaller focused components.

---

## Prompt 4
"Does my redesign properly demonstrate encapsulation and modularity?"

Summary of AI Response:
The AI confirmed that using private fields with public getters and setters in the Product class demonstrates encapsulation. It also noted that moving transformation logic to a separate class improves modularity.

I reviewed the explanation and ensured all fields were private and documented with Javadocs.

---

## Prompt 5
"How can I preserve identical functionality from Assignment 2 while refactoring into multiple classes?"

Summary of AI Response:
The AI emphasized keeping:
- The same transformation order
- The same rounding logic
- The same relative file paths
- The same error handling behavior
- The same console summary output

I carefully compared outputs from Assignment 2 and Assignment 3 to confirm they were identical.

---


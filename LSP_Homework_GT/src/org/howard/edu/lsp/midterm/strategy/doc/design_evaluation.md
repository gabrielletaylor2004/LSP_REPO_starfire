Design Evaluation of PriceCalculator

The PriceCalculator class works for the current set of customer types, but its design creates maintenance and extensibility problems as the system grows. The main issue is that the class relies on a sequence of conditional statements to determine discount behaviour. This means the logic for every pricing rule is hard-coded into a single method.

One design problem is that the class violates the Open-Closed Principle. The class is not closed for modification because every time a new customer type or discount rule is introduced, the calculatePrice method must be edited. For example, if the system later adds a STUDENT or BLACK_FRIDAY discount, the existing method must be changed. This increases the risk of introducing bugs into code that already works.

The class also has low cohesion because it directly manages multiple discount behaviours instead of delegating each pricing rule to a separate component. Each customer pricing rule represents a different behaviour, but all of them are mixed together in one method. This makes the code harder to read, test, and maintain.

Another weakness is that the implementation depends on string comparisons such as "REGULAR" and "VIP". This creates the possibility of typing errors, inconsistent naming, or invalid values being passed into the method. It also makes the design less flexible because behaviour selection depends on raw string values rather than polymorphism.

The current implementation does not take advantage of object-oriented design principles such as abstraction and encapsulation. Discount strategies are behaviours that should be modelled as separate objects. Instead, the class uses procedural logic with repeated if statements. As the number of pricing rules grows, this approach becomes more difficult to manage.

A better design would use the Strategy Pattern. In that design, each discount rule would be placed in its own class implementing a common strategy interface. The calculator would then delegate price calculation to the selected strategy object. This improves extensibility, supports cleaner code, and allows new discount types to be added without modifying existing pricing logic.

Overall, the current design works for a small example, but it is not ideal for a system that may evolve. Using the Strategy Pattern would make the design more maintainable, extensible, and aligned with object-oriented principles.
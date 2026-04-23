Heuristic 1:
Name: Encapsulation
All data should be hidden within its class.

Explanation:
In lecture, this was emphasized as a key principle of encapsulation, where all data members should be private and only accessed through methods. This prevents other classes from directly modifying internal data and protects the integrity of the object. It improves maintainability because changes to the internal implementation do not affect other parts of the system, as long as the public interface remains consistent. It also improves readability by clearly defining how the class is intended to be used.


Heuristic 2:
Name: Minimal public interface
Minimize the number of operations in the interface of a class.

Explanation: 
In lecture, this heuristic was discussed as a way to keep class interfaces simple and focused. A class should only expose the methods that are necessary for users of the class, rather than including excessive or unnecessary operations. This improves readability because it is easier to understand what the class does, and improves maintainability by reducing complexity and limiting how other classes depend on it.


Heuristic 3:
Name: Single abstraction/responsibility
A class should capture one and only one key abstraction.

Explanation:
In lecture, this was explained as ensuring that each class has a single, clear purpose. When a class tries to represent multiple concepts or responsibilities, it becomes harder to understand and modify. By focusing on one key abstraction, the design becomes more organized and easier to maintain, since changes to one part of the system are less likely to impact unrelated functionality.

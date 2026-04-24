Heuristic 1:
Name:Encapsulation
All data should be hidden within its class.

Explanation:
In lecture, this was emphasized through the heating system example, where the Room class initially exposed internal data such as temperature and occupancy through multiple access methods. The HeatFlowRegulator then used this low-level data to make decisions, which required Room to reveal too much of its internal state. In the improved design, Room encapsulated this data and instead provided a higher-level method (e.g., deciding if it needs heat). This improves maintainability because changes to internal data do not affect other classes, and improves readability by keeping data and behaviour together.


Heuristic 2:
Name:Minimal public interface
Minimize the number of operations in the interface of a class 

Explanation:
In lecture, the heating system example showed that the Room class originally had many get methods that exposed internal data to the HeatFlowRegulator. This created a cluttered interface and forced other classes to depend on low-level details. In the improved design, the interface was simplified by replacing multiple access methods with a single meaningful operation. This improves readability by making the class easier to understand, and improves maintainability by reducing unnecessary dependencies between classes.


Heuristic 3:
Name:Single abstraction
A class should capture one and only one key abstraction

Explanation:
In lecture, the heating system example demonstrated that the HeatFlowRegulator acted like a “god class” by handling too much logic, including decisions that belonged to the Room. This violated the idea that each class should represent one clear abstraction. In the improved design, responsibility was redistributed so that Room handled its own decision-making, while HeatFlowRegulator had a more limited role. This improves maintainability by separating responsibilities and improves readability by ensuring each class has a clear and focused purpose.

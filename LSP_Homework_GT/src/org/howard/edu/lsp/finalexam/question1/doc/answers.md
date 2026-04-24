Part 1:
Shared Resource #1: nextId (shared mutable state)

Shared Resource #2: requests (shared mutable state)

Concurrency Problem: Race condition due to shared mutable state. Multiple threads may access and modify shared resources simultaneously, leading to duplicate IDs or inconsistent request data.

Why addRequest() is unsafe: addRequest() calls getNextId() and then adds to requests without synchronization. Multiple threads can interleave execution of getNextId() and requests.add(). This creates a race condition, causing duplicate IDs (two threads read same nextId before increment), and/or lost updates or inconsistent list state. The method is not atomic; ID generation + insertion is not protected as a single operation.

Part 2:

Fix A: This fix is incorrect. Synchronizing only getNextId() ensures atomic ID generation, but requests.add() is still unsynchronized and the full operation (generate ID + add request) is not atomic. Race conditions can still occur between ID generation and list insertion.

Fix B: This fix is correct.Synchronizing addRequest() ensures only one thread executes the entire method at a time, and both ID generation and list insertion occur atomically. It eliminates race conditions on both nextId and requests.

Fix C: This fix is incorrect. Synchronizing getRequests() only protects read access. It does not prevent concurrent modification in addRequest(). Race conditions during writes still occur.

Part 3:
1. getNextId() should not be public.
2. According to Riel’s heuristics (information hiding / encapsulation), internal implementation details should not be exposed. nextId management is an internal concern of RequestManager. Making it public would allow external classes to manipulate ID generation, and break encapsulation and increase risk of misuse. It should be private or at most protected and only used internally.

Part 4:
Description: An alternative approach to managing concurrency that does not rely on the synchronized keyword is the use of atomic variables (e.g., AtomicInteger) instead of synchronized. AtomicInteger provides lock-free, thread-safe operations. It ensures that ID incrementation is atomic without blocking threads. It also combines with a thread-safe collection (e.g., Collections.synchronizedList or CopyOnWriteArrayList) to protect the shared list.


Code Snippet:

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class RequestManager {
    private AtomicInteger nextId = new AtomicInteger(1);
    private List<String> requests = new CopyOnWriteArrayList<>();

    public void addRequest(String studentName) {
        int id = nextId.getAndIncrement();
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    }
}
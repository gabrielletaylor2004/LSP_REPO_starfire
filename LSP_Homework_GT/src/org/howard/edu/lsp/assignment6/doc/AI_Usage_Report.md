## How AI Was Used
AI was used to:
- review the Assignment 6 rubric and instructions
- help adapt Assignment 5 `IntegerSet.java` into the Assignment 6 package
- generate JUnit 5 test cases for each required method
- ensure both normal cases and edge cases were covered according to the rubric
- verify that the required package structure and file naming conventions were followed

I manually reviewed the generated code, checked that all required methods were tested, and confirmed that the code matched the assignment specifications before submission.

Prompt: *Uploaded assignment 5 integerset.java and HW6 instructions* Here is the code from assignment 5, help me to creat junit 5 tests according to HW 6 guidelines.

package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    @Test
    void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    void testLength() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length());
        set.add(1);
        assertEquals(1, set.length());
    }

    @Test
    void testEquals() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(1);
        assertTrue(a.equals(b));

        b.add(3);
        assertFalse(a.equals(b));
    }

    @Test
    void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertTrue(set.contains(5));
        assertFalse(set.contains(10));
    }

    @Test
    void testLargest() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        assertEquals(3, set.largest());

        IntegerSet empty = new IntegerSet();
        assertThrows(RuntimeException.class, empty::largest);
    }

    @Test
    void testSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        assertEquals(3, set.smallest());

        IntegerSet empty = new IntegerSet();
        assertThrows(RuntimeException.class, empty::smallest);
    }

    @Test
    void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(1); // duplicate
        assertEquals(1, set.length());
    }

    @Test
    void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(1);
        assertFalse(set.contains(1));

        set.remove(5); // not present
        assertEquals(0, set.length());
    }

    @Test
    void testUnion() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        b.add(2);

        a.union(b);
        assertTrue(a.contains(2));

        IntegerSet empty = new IntegerSet();
        a.union(empty);
        assertEquals(2, a.length());
    }

    @Test
    void testIntersect() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1); a.add(2);
        b.add(2);

        a.intersect(b);
        assertTrue(a.contains(2));

        IntegerSet c = new IntegerSet();
        a.intersect(c);
        assertTrue(a.isEmpty());
    }

    @Test
    void testDiff() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1); a.add(2);
        b.add(1); b.add(2);

        a.diff(b);
        assertTrue(a.isEmpty());
    }

    @Test
    void testComplement() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        b.add(2);

        a.complement(b);
        assertTrue(a.contains(2));
    }

    @Test
    void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());

        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    void testToString() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());

        set.add(1);
        assertEquals("[1]", set.toString());
    }
}

Prompt: *Uploaded screenshot* My JUnit test showed 4 failures. How do I fix this?

You’ve got:

✅ JUnit working
✅ Tests running
❗ 4 failures (this is GOOD — means your tests are doing their job)
🔍 What’s failing?

From your screenshot:

❌ testComplement
❌ testUnion
❌ testDiff
❌ testIntersect

👀 Notice a pattern?

👉 All the set operations are failing

That means:

Your IntegerSet logic is slightly off, not your tests

🧠 Root problem (very likely)

Your methods are probably modifying the set incorrectly or not handling edge cases properly.

Let’s fix them cleanly.

✅ FIX THESE METHODS IN IntegerSet.java
🔹 1. union()

Should combine both sets without duplicates

public void union(IntegerSet intSetb) {
    for (int val : intSetb.set) {
        if (!set.contains(val)) {
            set.add(val);
        }
    }
}
🔹 2. intersect()

Keep ONLY common elements

public void intersect(IntegerSet intSetb) {
    set.removeIf(val -> !intSetb.set.contains(val));
}
🔹 3. diff()

Remove elements that exist in the other set

public void diff(IntegerSet intSetb) {
    set.removeIf(intSetb.set::contains);
}
🔹 4. complement() ⚠️ (THIS ONE USUALLY BREAKS)

This should become:

👉 elements in B that are NOT in A

public void complement(IntegerSet intSetb) {
    ArrayList<Integer> result = new ArrayList<>();

    for (int val : intSetb.set) {
        if (!set.contains(val)) {
            result.add(val);
        }
    }

    set = result;
}
🧪 AFTER FIXING

Do this:

Save file
Project → Clean
Run tests again
🎯 What should happen

Your panel should go from:

❌ Failures: 4

to:

✅ Failures: 0
✅ All green

🧠 Why this happened

Set operations are like social circles:

union → everyone invited
intersect → only mutual friends
diff → remove shared people
complement → “who’s in theirs but not mine?”

Your code just needed to enforce those rules correctly.
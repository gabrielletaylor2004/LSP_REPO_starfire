package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

/**
 * JUnit 5 test cases for IntegerSet.
 * Each method includes both normal and edge case testing
 * based on the assignment rubric.
 */
public class IntegerSetTest {

    @Test
    void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.length());

        set.clear(); // edge: clearing an already empty set
        assertTrue(set.isEmpty());
    }

    @Test
    void testLength() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length()); // edge: empty set

        set.add(1);
        set.add(2);
        assertEquals(2, set.length()); // normal case
    }

    @Test
    void testEquals() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        a.add(2);
        b.add(2);
        b.add(1);

        assertTrue(a.equals(b)); // same elements, different order

        b.add(3);
        assertFalse(a.equals(b)); // mismatch case
    }

    @Test
    void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(5);

        assertTrue(set.contains(5));   // present
        assertFalse(set.contains(10)); // absent
    }

    @Test
    void testLargest() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(8);
        set.add(1);

        assertEquals(8, set.largest()); // normal case

        IntegerSet single = new IntegerSet();
        single.add(4);
        assertEquals(4, single.largest()); // single element edge

        IntegerSet empty = new IntegerSet();
        assertThrows(NoSuchElementException.class, empty::largest); // exception case
    }

    @Test
    void testSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(8);
        set.add(1);

        assertEquals(1, set.smallest()); // normal case

        IntegerSet single = new IntegerSet();
        single.add(4);
        assertEquals(4, single.smallest()); // single element edge

        IntegerSet empty = new IntegerSet();
        assertThrows(NoSuchElementException.class, empty::smallest); // exception case
    }

    @Test
    void testAdd() {
        IntegerSet set = new IntegerSet();

        set.add(1); // normal case
        assertTrue(set.contains(1));
        assertEquals(1, set.length());

        set.add(1); // duplicate edge case
        assertEquals(1, set.length());
    }

    @Test
    void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);

        set.remove(1); // normal case
        assertFalse(set.contains(1));
        assertEquals(1, set.length());

        set.remove(5); // edge: value not present
        assertEquals(1, set.length());
    }

    @Test
    void testUnion() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        a.add(2);
        b.add(2);
        b.add(3);

        a.union(b); // normal case
        assertEquals("[1, 2, 3]", a.toString());

        IntegerSet empty = new IntegerSet();
        a.union(empty); // edge: union with empty set
        assertEquals("[1, 2, 3]", a.toString());
    }

    @Test
    void testIntersect() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        a.add(2);
        a.add(3);
        b.add(2);
        b.add(3);
        b.add(4);

        a.intersect(b); // normal case
        assertEquals("[2, 3]", a.toString());

        IntegerSet c = new IntegerSet();
        a.intersect(c); // edge: no overlap
        assertTrue(a.isEmpty());
    }

    @Test
    void testDiff() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        a.add(2);
        a.add(3);
        b.add(2);

        a.diff(b); // normal case
        assertEquals("[1, 3]", a.toString());

        IntegerSet x = new IntegerSet();
        IntegerSet y = new IntegerSet();
        x.add(1);
        x.add(2);
        y.add(1);
        y.add(2);

        x.diff(y); // edge: identical sets
        assertTrue(x.isEmpty());
    }

    @Test
    void testComplement() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();

        a.add(1);
        a.add(2);
        b.add(2);
        b.add(3);
        b.add(4);

        a.complement(b); // normal case
        assertEquals("[3, 4]", a.toString());

        IntegerSet x = new IntegerSet();
        IntegerSet y = new IntegerSet();
        x.add(1);
        y.add(2);
        y.add(3);

        x.complement(y); // edge: disjoint sets
        assertEquals("[2, 3]", x.toString());
    }

    @Test
    void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty()); // empty case

        set.add(1);
        assertFalse(set.isEmpty()); // non-empty case
    }

    @Test
    void testToString() {
        IntegerSet empty = new IntegerSet();
        assertEquals("[]", empty.toString()); // edge: empty set

        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(1);
        set.add(2);
        assertEquals("[1, 2, 3]", set.toString()); // normal case with sorting
    }
}

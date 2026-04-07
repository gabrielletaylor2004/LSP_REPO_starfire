package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Represents a mathematical set of integers.
 * <p>
 * This class stores unique integer values and supports standard set operations
 * such as union, intersection, difference, and complement. Duplicate values are
 * not allowed.
 */
public class IntegerSet {
    /** Internal storage for unique integer values in the set. */
    private final ArrayList<Integer> set = new ArrayList<>();

    /**
     * Removes all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares this set with another set for equality.
     * Two sets are equal if they contain exactly the same elements,
     * regardless of order.
     *
     * @param b the other set to compare against
     * @return true if both sets contain exactly the same elements; false otherwise
     */
    public boolean equals(IntegerSet b) {
        if (b == null) {
            return false;
        }
        if (this.length() != b.length()) {
            return false;
        }

        ArrayList<Integer> thisCopy = new ArrayList<>(this.set);
        ArrayList<Integer> otherCopy = new ArrayList<>(b.set);
        Collections.sort(thisCopy);
        Collections.sort(otherCopy);

        return thisCopy.equals(otherCopy);
    }

    /**
     * Determines whether the set contains the specified value.
     *
     * @param value the value to search for
     * @return true if the value is in the set; false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     *
     * @return the largest integer in the set
     * @throws NoSuchElementException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new NoSuchElementException("IntegerSet is empty.");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest value in the set.
     *
     * @return the smallest integer in the set
     * @throws NoSuchElementException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new NoSuchElementException("IntegerSet is empty.");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already present.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes the specified item from the set if it exists.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set containing all elements that appear in either set.
     * Neither original set is modified.
     *
     * @param intSetb the other set
     * @return a new set representing the union of the two sets
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int value : this.set) {
            result.add(value);
        }
        if (intSetb != null) {
            for (int value : intSetb.set) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing only elements common to both sets.
     * Neither original set is modified.
     *
     * @param intSetb the other set
     * @return a new set representing the intersection of the two sets
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        if (intSetb == null) {
            return result;
        }

        for (int value : this.set) {
            if (intSetb.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing elements in this set but not in the other set.
     * Neither original set is modified.
     *
     * @param intSetb the other set
     * @return a new set representing the difference of this set and the other set
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int value : this.set) {
            if (intSetb == null || !intSetb.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing elements in the other set but not in this set.
     * Neither original set is modified.
     *
     * @param intSetb the other set
     * @return a new set representing the complement of this set relative to the other set
     */
    public IntegerSet complement(IntegerSet intSetb) {
        if (intSetb == null) {
            return new IntegerSet();
        }
        return intSetb.diff(this);
    }

    /**
     * Determines whether the set has no elements.
     *
     * @return true if the set is empty; false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * The required format is [1, 2, 3]. An empty set is represented as [].
     *
     * @return the set as a formatted string in ascending order
     */
    @Override
    public String toString() {
        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}
package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Represents a mathematical set of integers.
 * <p>
 * This class stores unique integer values and supports common set operations
 * such as union, intersection, difference, and complement. Duplicate values
 * are not allowed. Most set operations modify the current set directly rather
 * than returning a new set.
 */
public class IntegerSet {

    /**
     * Internal storage for the unique elements in the set.
     */
    private final ArrayList<Integer> set = new ArrayList<>();

    /**
     * Removes all elements from the set.
     * <p>
     * After this method executes, the set will be empty.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements currently in the set.
     *
     * @return the size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares this set to another set for equality.
     * <p>
     * Two sets are considered equal if they contain exactly the same elements,
     * regardless of order. If the specified set is {@code null}, this method
     * returns {@code false}.
     *
     * @param b the set to compare with this set
     * @return {@code true} if both sets contain the same elements;
     *         {@code false} otherwise
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
     * Determines whether the specified value is present in the set.
     *
     * @param value the integer value to search for
     * @return {@code true} if the value exists in the set;
     *         {@code false} otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     *
     * @return the largest integer stored in the set
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
     * @return the smallest integer stored in the set
     * @throws NoSuchElementException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new NoSuchElementException("IntegerSet is empty.");
        }
        return Collections.min(set);
    }

    /**
     * Adds the specified item to the set if it is not already present.
     * <p>
     * Because this class represents a mathematical set, duplicate values are
     * ignored.
     *
     * @param item the integer value to add
     */
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes the specified item from the set if it is present.
     * <p>
     * If the item does not exist in the set, the method does nothing.
     *
     * @param item the integer value to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Updates this set so that it becomes the union of this set and the
     * specified set.
     * <p>
     * After this operation, this set contains every unique element that appears
     * in either set. If the specified set is {@code null}, this set remains
     * unchanged.
     *
     * @param intSetb the other set whose elements are added into this set
     */
    public void union(IntegerSet intSetb) {
        if (intSetb == null) {
            return;
        }
        for (int value : intSetb.set) {
            if (!this.contains(value)) {
                this.add(value);
            }
        }
    }

    /**
     * Updates this set so that it contains only elements common to both this
     * set and the specified set.
     * <p>
     * If the specified set is {@code null}, this set becomes empty because
     * there can be no common elements.
     *
     * @param intSetb the other set used to determine the common elements
     */
    public void intersect(IntegerSet intSetb) {
        if (intSetb == null) {
            this.clear();
            return;
        }
        set.removeIf(value -> !intSetb.contains(value));
    }

    /**
     * Updates this set by removing all elements that are also contained in the
     * specified set.
     * <p>
     * After this operation, this set contains only elements that are in this
     * set but not in the specified set. If the specified set is {@code null},
     * this set remains unchanged.
     *
     * @param intSetb the set containing elements to remove from this set
     */
    public void diff(IntegerSet intSetb) {
        if (intSetb == null) {
            return;
        }
        set.removeIf(intSetb::contains);
    }

    /**
     * Updates this set so that it becomes the complement of this set relative
     * to the specified set.
     * <p>
     * In other words, after this operation this set contains the elements that
     * are in the specified set but not in this set.
     * <p>
     * Example:
     * If this set is [1, 2] and the specified set is [2, 3, 4],
     * then this set becomes [3, 4].
     * <p>
     * If the specified set is {@code null}, this set becomes empty.
     *
     * @param intSetb the set used to compute the complement
     */
    public void complement(IntegerSet intSetb) {
        if (intSetb == null) {
            this.clear();
            return;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int value : intSetb.set) {
            if (!this.contains(value)) {
                result.add(value);
            }
        }

        this.clear();
        for (int value : result) {
            this.add(value);
        }
    }

    /**
     * Determines whether the set contains no elements.
     *
     * @return {@code true} if the set is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * <p>
     * The format matches the assignment requirement exactly, such as
     * {@code [1, 2, 3]}. An empty set is represented as {@code []}.
     *
     * @return the set as a sorted string
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}
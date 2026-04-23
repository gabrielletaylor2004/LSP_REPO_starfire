package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {

    @Test
    void testAverageCalculatesCorrectAverage() {
        GradeCalculator calculator = new GradeCalculator();

        assertEquals(85.0, calculator.average(80, 85, 90), 0.001);
    }

    @Test
    void testLetterGradeReturnsCorrectLetterGrades() {
        GradeCalculator calculator = new GradeCalculator();

        assertEquals("A", calculator.letterGrade(90));
        assertEquals("B", calculator.letterGrade(80));
        assertEquals("C", calculator.letterGrade(70));
        assertEquals("D", calculator.letterGrade(60));
        assertEquals("F", calculator.letterGrade(59.9));
    }

    @Test
    void testIsPassingReturnsCorrectBoolean() {
        GradeCalculator calculator = new GradeCalculator();

        assertTrue(calculator.isPassing(60));
        assertFalse(calculator.isPassing(59.9));
    }

    @Test
    void testAverageAcceptsMinimumBoundaryScore() {
        GradeCalculator calculator = new GradeCalculator();

        assertEquals(0.0, calculator.average(0, 0, 0), 0.001);
    }

    @Test
    void testAverageAcceptsMaximumBoundaryScore() {
        GradeCalculator calculator = new GradeCalculator();

        assertEquals(100.0, calculator.average(100, 100, 100), 0.001);
    }

    @Test
    void testAverageThrowsExceptionForScoreBelowZero() {
        GradeCalculator calculator = new GradeCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(-1, 80, 90);
        });
    }

    @Test
    void testAverageThrowsExceptionForScoreAboveOneHundred() {
        GradeCalculator calculator = new GradeCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(101, 80, 90);
        });
    }
}

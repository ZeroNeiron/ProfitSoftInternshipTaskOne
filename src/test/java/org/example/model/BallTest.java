package org.example.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BallTest {
    @Test
    void calculateArea_validInputData_positive() {
        Double expected = 4.1887902047863905;
        Ball ball = Ball.create(1.0);
        Assertions.assertEquals(expected, ball.calculateArea());
    }

    @Test
    void calculateArea_invalidInputData_negative() {
        Double expected = 27.0;
        Ball ball = Ball.create(1.0);
        Assertions.assertNotEquals(expected, ball.calculateArea());
    }

    @Test
    void calculateArea_nullLength_positive() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,() -> Ball.create(null));
        assertTrue(exception.getMessage().contains("\"radius\" is null"));
    }

    @Test
    void calculateArea_negativeLength_positive() {
        Double expected = 0.0;
        Ball ball = Ball.create(-1.0);
        Assertions.assertEquals(expected, ball.calculateArea());
    }
}
package org.example.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CubeTest {
    @Test
    void calculateArea_validInputData_positive() {
        Double expected = 27.0;
        Cube cube = Cube.create(3.0);
        Assertions.assertEquals(expected, cube.calculateArea());
    }

    @Test
    void calculateArea_invalidInputData_negative() {
        Double expected = 27.0;
        Cube cube = Cube.create(1.0);
        Assertions.assertNotEquals(expected, cube.calculateArea());
    }

    @Test
    void calculateArea_nullLength_positive() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,() -> Cube.create(null));
        assertTrue(exception.getMessage().contains("\"edge\" is null"));
    }

    @Test
    void calculateArea_negativeLength_positive() {
        Double expected = 0.0;
        Cube cube = Cube.create(-1.0);
        Assertions.assertEquals(expected, cube.calculateArea());
    }
}

package org.example.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CylinderTest {
    @Test
    void calculateArea_validInputData_positive() {
        Double expected = 3.141592653589793;
        Cylinder cylinder = Cylinder.create(1.0, 1.0);
        Assertions.assertEquals(expected, cylinder.calculateArea());
    }

    @Test
    void calculateArea_invalidInputData_negative() {
        Double expected = 27.0;
        Cylinder cylinder = Cylinder.create(1.0, 1.0);
        Assertions.assertNotEquals(expected, cylinder.calculateArea());
    }

    @Test
    void calculateArea_nullLength_positive() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,() -> Cylinder.create(null, null));
        assertTrue(exception.getMessage().contains("\"height\" is null"));
    }

    @Test
    void calculateArea_negativeLength_positive() {
        Double expected = 0.0;
        Cylinder cylinder = Cylinder.create(-1.0, -1.0);
        Assertions.assertEquals(expected, cylinder.calculateArea());
    }
}
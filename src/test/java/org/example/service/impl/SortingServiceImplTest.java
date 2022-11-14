package org.example.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.model.Ball;
import org.example.model.Cube;
import org.example.model.Cylinder;
import org.example.model.Shape;
import org.example.service.SortingService;
import org.junit.jupiter.api.Test;

class SortingServiceImplTest {
    private final SortingService sortingService = new SortingServiceImpl();

    @Test
    void sortPositiveNumbersByDesc_validInputData_positive() {
        Integer array[] = {-1, 0, 3, 2, 4, 1, 4};
        Integer expected[] = {4, 4, 3, 2, 1, 0};
        assertArrayEquals(expected, sortingService.sortPositiveNumbersByDesc(array));
    }

    @Test
    void sortPositiveNumbersByDesc_emptyArray_positive() {
        Integer array[] = {};
        Integer expected[] = {};
        assertArrayEquals(expected, sortingService.sortPositiveNumbersByDesc(array));
    }

    @Test
    void sortPositiveNumbersByDesc_negativeArray_positive() {
        Integer array[] = {-1, -2, -3, -4, -5, -6};
        Integer expected[] = {};
        assertArrayEquals(expected, sortingService.sortPositiveNumbersByDesc(array));
    }

    @Test
    void sortPositiveNumbersByDesc_positiveArray_positive() {
        Integer array[] = {1, 2, 3, 2, 1};
        Integer expected[] = {3, 2, 2, 1, 1};
        assertArrayEquals(expected, sortingService.sortPositiveNumbersByDesc(array));
    }

    @Test
    void sortPositiveNumbersByDesc_nullArray_positive() {
        Integer[] array = null;
        NullPointerException exception = assertThrows(
                NullPointerException.class,() -> sortingService.sortPositiveNumbersByDesc(array));
        assertTrue(exception.getMessage().contains("\"array\" is null"));
    }

    @Test
    void sortShapesByArea_validInputData_positive() {
        Shape cube = Cube.create(1.0);
        Shape ball = Ball.create(1.0);
        Shape cylinder = Cylinder.create(1.0, 1.0);

        List<Shape> shapes = List.of(ball, cylinder, cube);

        List<Shape> expected = List.of(cube, cylinder, ball);

        assertEquals(expected, sortingService.sortShapesByArea(shapes));
    }

    @Test
    void sortShapesByArea_emptyList_positive() {
        List<Shape> shapes = Collections.emptyList();
        List<Shape> expected = Collections.emptyList();

        assertEquals(expected, sortingService.sortShapesByArea(shapes));
    }

    @Test
    void sortShapesByArea_sameShapes_positive() {
        Shape cube1 = Cube.create(1.0);
        Shape cube2 = Cube.create(2.0);
        Shape cube3 = Cube.create(3.0);

        List<Shape> shapes = List.of(cube3, cube1, cube2);

        List<Shape> expected = List.of(cube1, cube2, cube3);

        assertEquals(expected, sortingService.sortShapesByArea(shapes));
    }

    @Test
    void sortShapesByArea_oneShape_positive() {
        Shape cube = Cube.create(1.0);

        List<Shape> shapes = List.of(cube);

        List<Shape> expected = List.of(cube);

        assertEquals(expected, sortingService.sortShapesByArea(shapes));
    }

    @Test
    void sortShapesByArea_nullList_positive() {
        List<Shape> shapes = null;
        NullPointerException exception = assertThrows(
                NullPointerException.class,() -> sortingService.sortShapesByArea(shapes));
        assertTrue(exception.getMessage().contains("\"shapes\" is null"));
    }
}
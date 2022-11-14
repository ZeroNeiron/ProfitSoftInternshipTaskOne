package org.example.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.example.model.Shape;
import org.example.service.SortingService;

public class SortingServiceImpl implements SortingService {
    @Override
    public Integer[] sortPositiveNumbersByDesc(Integer[] array) {
        return Arrays.stream(array)
                .parallel()
                .filter(n -> n >= 0)
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);
    }

    @Override
    public List<Shape> sortShapesByArea(List<Shape> shapes) {
        return shapes.stream()
                .parallel()
                .sorted(Comparator.comparing(Shape::calculateArea))
                .collect(Collectors.toList());
    }
}

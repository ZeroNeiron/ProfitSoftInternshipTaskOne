package org.example.service;

import java.util.List;
import org.example.model.Shape;

public interface SortingService {
    Integer[] sortPositiveNumbersByDesc(Integer[] array);

    List<Shape> sortShapesByArea(List<Shape> shapes);
}

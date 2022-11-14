package org.example.model;

public class Cube implements Shape {
    private Double edge;

    private Cube() {
    }

    public static Cube create(Double edge) {
        Cube cube = new Cube();
        cube.setEdge(edge);
        return cube;
    }

    public Double getEdge() {
        return edge;
    }

    public void setEdge(Double edge) {
        if (edge > 0) {
            this.edge = edge;
            return;
        }
        this.edge = 0.0;
    }

    @Override
    public Double calculateArea() {
        return Math.pow(edge, 3);
    }
}

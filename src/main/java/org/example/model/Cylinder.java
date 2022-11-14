package org.example.model;

public class Cylinder implements Shape {
    private Double height;
    private Double radius;

    private Cylinder() {
    }

    public static Cylinder create(Double height, Double radius) {
        Cylinder cylinder = new Cylinder();
        cylinder.setHeight(height);
        cylinder.setRadius(radius);
        return cylinder;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        if (height > 0) {
            this.height = height;
            return;
        }
        this.height = 0.0;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        if (radius > 0) {
            this.radius = radius;
            return;
        }
        this.radius = 0.0;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}

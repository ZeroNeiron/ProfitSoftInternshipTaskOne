package org.example.model;

public class Ball implements Shape {
    private Double radius;

    private Ball() {
    }

    public static Ball create(Double radius) {
        Ball ball = new Ball();
        ball.setRadius(radius);
        return ball;
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
        return (4. / 3.) * Math.PI * Math.pow(radius, 3);
    }
}

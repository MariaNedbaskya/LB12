package com.example.domain;

public class Circle extends GeometricFigure{

    private Employee emp;

    public CircleEmployee() {
        super();
        this.employee = new Employee();
    }
    private double radius;

    public Circle() {
        super();
    }

    public Circle(String color, double radius) {
        super("Круг", color, Math.PI * radius * radius);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        this.area = Math.PI * radius * radius;
    }

    @Override
    public void displayInfo() {
        System.out.println("Круг: " +
                "Цвет = " + color +
                ", Радиус = " + radius +
                ", Площадь = " + String.format("%.2f", area));
    }
}
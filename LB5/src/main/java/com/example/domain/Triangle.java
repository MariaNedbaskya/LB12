package com.example.domain;

public class Triangle extends GeometricFigure {
    private double base;
    private double height;

    public Triangle() {
        super();
    }

    public Triangle(String color, double base, double height) {
        super("Треугольник", color, 0.5 * base * height);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
        this.area = 0.5 * base * height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        this.area = 0.5 * base * height;
    }

    @Override
    public void displayInfo() {
        System.out.println("Треугольник: " +
                "Цвет = " + color +
                ", Основание = " + base +
                ", Высота = " + height +
                ", Площадь = " + area);
    }
}
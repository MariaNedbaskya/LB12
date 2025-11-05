package com.example.domain;

public class GeometricFigure {
    protected String name;
    protected String color;
    protected double area;

    public GeometricFigure() {}

    public GeometricFigure(String name, String color, double area) {
        this.name = name;
        this.color = color;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void displayInfo() {
        System.out.println("Фигура: " + name + ", Цвет: " + color + ", Площадь: " + area);
    }
}
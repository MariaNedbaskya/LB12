package com.example.domain;

public class Rectangle extends GeometricFigure {
    private double width;
    private double height;

    public Rectangle() {
        super();
    }

    public Rectangle(String color, double width, double height) {
        super("Прямоугольник", color, width * height);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        this.area = width * height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        this.area = width * height;
    }

    @Override
    public void displayInfo() {
        System.out.println("Прямоугольник: " +
                "Цвет = " + color +
                ", Ширина = " + width +
                ", Высота = " + height +
                ", Площадь = " + area);
    }
}
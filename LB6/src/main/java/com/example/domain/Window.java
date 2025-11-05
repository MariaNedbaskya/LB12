package com.example.domain;

public class Window {
    private String material;
    private boolean isOpen;
    private double width;
    private double height;

    public Window() {
        this.material = "Дерево";
        this.isOpen = false;
        this.width = 1.2;
        this.height = 1.5;
    }

    public Window(String material, boolean isOpen, double width, double height) {
        this.material = material;
        this.isOpen = isOpen;
        this.width = width;
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void openWindow() {
        this.isOpen = true;
        System.out.println("Окно открыто");
    }

    public void closeWindow() {
        this.isOpen = false;
        System.out.println("Окно закрыто");
    }

    @Override
    public String toString() {
        return "Окно {" +
                "материал='" + material + '\'' +
                ", открыто=" + (isOpen ? "да" : "нет") +
                ", размер=" + width + "x" + height +
                '}';
    }
}
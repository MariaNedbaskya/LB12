package com.example.domain;

public class Door {
    private String material;
    private boolean isOpen;
    private boolean isLocked;
    private String color;

    public Door() {
        this.material = "Дерево";
        this.isOpen = false;
        this.isLocked = false;
        this.color = "Коричневый";
    }

    public Door(String material, boolean isOpen, boolean isLocked, String color) {
        this.material = material;
        this.isOpen = isOpen;
        this.isLocked = isLocked;
        this.color = color;
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

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void openDoor() {
        if (!isLocked) {
            this.isOpen = true;
            System.out.println("Дверь открыта");
        } else {
            System.out.println("Дверь заперта на ключ! Нельзя открыть.");
        }
    }

    public void closeDoor() {
        this.isOpen = false;
        System.out.println("Дверь закрыта");
    }

    public void lockDoor() {
        this.isLocked = true;
        System.out.println("Дверь заперта на ключ");
    }

    public void unlockDoor() {
        this.isLocked = false;
        System.out.println("Дверь открыта ключом");
    }

    @Override
    public String toString() {
        return "Дверь {" +
                "материал='" + material + '\'' +
                ", открыта=" + (isOpen ? "да" : "нет") +
                ", заперта=" + (isLocked ? "да" : "нет") +
                ", цвет='" + color + '\'' +
                '}';
    }
}
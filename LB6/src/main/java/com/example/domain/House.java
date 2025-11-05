package com.example.domain;

import java.util.ArrayList;
import java.util.List;

public class House {
    private String address;
    private List<Window> windows;
    private List<Door> doors;
    private boolean isAllLocked;

    // Конструкторы
    public House() {
        this.address = "Неизвестный адрес";
        this.windows = new ArrayList<>();
        this.doors = new ArrayList<>();
        this.isAllLocked = false;
    }

    public House(String address) {
        this.address = address;
        this.windows = new ArrayList<>();
        this.doors = new ArrayList<>();
        this.isAllLocked = false;
    }

    public House(String address, List<Window> windows, List<Door> doors) {
        this.address = address;
        this.windows = windows;
        this.doors = doors;
        this.isAllLocked = false;
    }

    // Геттеры и сеттеры
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public boolean isAllLocked() {
        return isAllLocked;
    }

    // Методы для добавления окон и дверей
    public void addWindow(Window window) {
        windows.add(window);
        System.out.println("Окно добавлено в дом");
    }

    public void addDoor(Door door) {
        doors.add(door);
        System.out.println("Дверь добавлена в дом");
    }

    // Основные методы по заданию

    // 1. Метод закрыть на ключ
    public void lockAllDoors() {
        for (Door door : doors) {
            door.lockDoor();
        }
        this.isAllLocked = true;
        System.out.println("Все двери дома заперты на ключ");
    }

    // 2. Метод вывести количество окон
    public void printWindowCount() {
        System.out.println("Количество окон в доме: " + windows.size());
    }

    // 3. Метод вывести количество дверей
    public void printDoorCount() {
        System.out.println("Количество дверей в доме: " + doors.size());
    }

    // Дополнительные полезные методы
    public void openAllWindows() {
        for (Window window : windows) {
            window.openWindow();
        }
        System.out.println("Все окна открыты");
    }

    public void closeAllWindows() {
        for (Window window : windows) {
            window.closeWindow();
        }
        System.out.println("Все окна закрыты");
    }

    public void displayHouseInfo() {
        System.out.println("\n=== ИНФОРМАЦИЯ О ДОМЕ ===");
        System.out.println("Адрес: " + address);
        printWindowCount();
        printDoorCount();
        System.out.println("Все двери заперты: " + (isAllLocked ? "да" : "нет"));

        System.out.println("\nОкна:");
        for (int i = 0; i < windows.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + windows.get(i));
        }

        System.out.println("\nДвери:");
        for (int i = 0; i < doors.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + doors.get(i));
        }
        System.out.println("========================\n");
    }

    @Override
    public String toString() {
        return "Дом {" +
                "адрес='" + address + '\'' +
                ", окон=" + windows.size() +
                ", дверей=" + doors.size() +
                ", заперт=" + (isAllLocked ? "да" : "нет") +
                '}';
    }
}
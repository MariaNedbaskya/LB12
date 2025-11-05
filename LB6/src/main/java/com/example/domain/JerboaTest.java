package com.example.domain;

public class JerboaTest {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ С КЛАССОМ ТУШКАНЧИК ===\n");


        Jerboa jerboa1 = new Jerboa();
        System.out.println("1. Тушканчик по умолчанию: " + jerboa1);

        Jerboa jerboa2 = new Jerboa("Пушок", 2, 0.15, "Степь");
        System.out.println("2. Тушканчик с параметрами: " + jerboa2);


        Jerboa jerboa3 = new Jerboa(jerboa2);
        jerboa3.name = "Копия Пушка";
        System.out.println("3. Копия тушканчика: " + jerboa3);



        jerboa1.name = "Джерри";
        System.out.println("Public поле name: " + jerboa1.name);


        jerboa1.age = 1;
        System.out.println("Protected поле age: " + jerboa1.age);


        jerboa1.setWeight(0.12);
        System.out.println("Private поле weight через геттер: " + jerboa1.getWeight());


        jerboa1.habitat = "Полупустыня";
        System.out.println("Default поле habitat: " + jerboa1.habitat);


        System.out.print("Public метод jump(): ");
        jerboa1.jump();

        System.out.print("Protected метод eat(): ");
        jerboa1.eat("насекомых");

        System.out.print("Default метод digHole(): ");
        jerboa1.digHole();


        System.out.println("\nМетод dailyRoutine() (использует private метод внутри):");
        jerboa1.dailyRoutine();


        System.out.println("Статическое поле species: " + Jerboa.species);

        System.out.println("Статический метод displaySpeciesInfo():");
        Jerboa.displaySpeciesInfo();

        System.out.println("Статическая константа MAX_JUMP_DISTANCE: " + Jerboa.MAX_JUMP_DISTANCE);


        System.out.println("До изменений: " + jerboa2);
        jerboa2.age = 3;
        jerboa2.setWeight(0.18);
        jerboa2.name = "Пушистик";
        jerboa2.habitat = "Пустыня";
        System.out.println("После изменений: " + jerboa2);

        jerboa2.setWeight(-0.5);

        System.out.println(jerboa1);
        System.out.println(jerboa2);
        System.out.println(jerboa3);

        System.out.println("\n\n=== ДЕМОНСТРАЦИЯ РАБОТЫ С КЛАССАМИ ДОМ, ОКНО, ДВЕРЬ ===");

        Window window1 = new Window("Пластик", false, 1.5, 2.0);
        Window window2 = new Window("Дерево", true, 1.2, 1.8);
        Window window3 = new Window("Алюминий", false, 2.0, 2.2);

        Door frontDoor = new Door("Дуб", false, false, "Коричневый");
        Door backDoor = new Door("Металл", true, false, "Белый");
        Door interiorDoor = new Door("Стекло", false, false, "Прозрачный");

        House myHouse = new House("ул. Центральная, д. 123");

        myHouse.addWindow(window1);
        myHouse.addWindow(window2);
        myHouse.addWindow(window3);

        myHouse.addDoor(frontDoor);
        myHouse.addDoor(backDoor);
        myHouse.addDoor(interiorDoor);

        myHouse.displayHouseInfo();

        System.out.println("=== ВЫПОЛНЕНИЕ ЗАДАНИЯ ===");

        myHouse.printWindowCount();

        myHouse.printDoorCount();

        myHouse.lockAllDoors();

        System.out.println("\nПытаемся открыть запертую дверь:");
        frontDoor.openDoor();

    }
}
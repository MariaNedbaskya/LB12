package com.example.domain;

public class Jerboa {

    public String name;

    protected int age;

    private double weight;

    String habitat;

    public static String species = "Тушканчик обыкновенный";

    public static final int MAX_JUMP_DISTANCE = 3;

    public Jerboa() {
        this.name = "Безымянный";
        this.age = 0;
        this.weight = 0.1;
        this.habitat = "Пустыня";
    }

    public Jerboa(String name, int age, double weight, String habitat) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.habitat = habitat;
    }

    public Jerboa(Jerboa other) {
        this.name = other.name;
        this.age = other.age;
        this.weight = other.weight;
        this.habitat = other.habitat;
    }


    public void jump() {
        System.out.println(name + " прыгает на расстояние до " + MAX_JUMP_DISTANCE + " метров!");
    }

    protected void eat(String food) {
        System.out.println(name + " ест " + food);
        this.weight += 0.01;
    }

    private void sleep() {
        System.out.println(name + " спит в своей норке");
    }

    void digHole() {
        System.out.println(name + " роет норку в " + habitat);
    }

    public static void displaySpeciesInfo() {
        System.out.println("Вид: " + species);
        System.out.println("Максимальная длина прыжка: " + MAX_JUMP_DISTANCE + " м");
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("Вес должен быть положительным!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Возраст не может быть отрицательным!");
        }
    }

    public void dailyRoutine() {
        System.out.println("Распорядок дня " + name );
        eat("семена");
        jump();
        digHole();
        sleep();

    }

    @Override
    public String toString() {
        return "Тушканчик {" +
                "имя='" + name + '\'' +
                ", возраст=" + age + " лет" +
                ", вес=" + weight + " кг" +
                ", среда обитания='" + habitat + '\'' +
                '}';
    }
}
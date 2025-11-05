public class Tester {
    String name;
    String surname;
    int expirienceInYears;
    String englishLevel;
    double salary;

    public Tester(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Tester(String name, String surname, int expirienceInYears) {
        this(name, surname);
        this.expirienceInYears = expirienceInYears;
    }

    public Tester(String name, String surname, int expirienceInYears, String englishLevel, double salary) {
        this(name, surname, expirienceInYears);
        this.englishLevel = englishLevel;
        this.salary = salary;
    }

    public void info() {
        System.out.println("Имя: " + name);
        System.out.println("Фамилия: " + surname);
        System.out.println("Опыт работы: " + expirienceInYears);
        System.out.println("Уровень английского: " + englishLevel);
        System.out.println("Зарплата: " + salary);
    }

    public void work(String task) {
        System.out.println(name + " работает над: " + task);
    }

    public void work(int hours) {
        System.out.println(name + " работает " + hours + " часов");
    }

    public static void printProfession() {
        System.out.println("Профессия: Тестировщик");
    }
}
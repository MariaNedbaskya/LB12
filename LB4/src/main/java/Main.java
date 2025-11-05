public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Иван");

        Tester tester1 = new Tester("Иван", "Иванов", 3, "B2", 35000);

        tester1.info();
        tester1.work("тестирование");
        tester1.work(8);

        Tester.printProfession();
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Иван Иванов", "ГР-01", 3,
                Arrays.asList(4, 5, 3, 4, 5)));
        students.add(new Student("Петр Петров", "ГР-01", 2,
                Arrays.asList(3, 3, 2, 3, 2)));
        students.add(new Student("Мария Сидорова", "ГР-02", 2,
                Arrays.asList(5, 5, 5, 5, 5)));
        students.add(new Student("Анна Козлова", "ГР-03", 1,
                Arrays.asList(3, 3, 3, 3, 3)));

        System.out.println("\nДО ОБРАБОТКИ");
        StudentManager.printAllStudents(students);

        System.out.println("\nПРОЦЕСС ОБРАБОТКИ");
        StudentManager.processStudents(students);

        System.out.println("\nПОСЛЕ ОБРАБОТКИ");
        StudentManager.printAllStudents(students);

        StudentManager.printStudents(students, 1);
        StudentManager.printStudents(students, 2);
        StudentManager.printStudents(students, 3);
        StudentManager.printStudents(students, 4);

    }
}
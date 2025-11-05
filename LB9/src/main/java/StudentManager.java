import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentManager {
    public static void processStudents(List<Student> students) {
        if (students == null) return;

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            double averageGrade = student.getAverageGrade();

            if (averageGrade < 3.0) {
                iterator.remove();
                System.out.println("Студент " + student.getName() + " отчислен (средний балл: " +
                        String.format("%.2f", averageGrade) + ")");
            } else {
                student.promoteToNextCourse();
                System.out.println("Студент " + student.getName() + " переведен на " +
                        student.getCourse() + " курс (средний балл: " +
                        String.format("%.2f", averageGrade) + ")");
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        if (students == null || students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }

        System.out.println("\nСтуденты " + course + " курса");
        boolean found = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("- " + student.getName() +
                        " (группа: " + student.getGroup() +
                        ", средний балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("На " + course + " курсе нет студентов.");
        }
    }

    public static void printAllStudents(List<Student> students) {
        if (students == null || students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }

        System.out.println("\nВсе студенты");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
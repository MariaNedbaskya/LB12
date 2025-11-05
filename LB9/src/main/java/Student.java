import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>(grades);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void setGrades(List<Integer> grades) {
        this.grades = new ArrayList<>(grades);
    }

    public double getAverageGrade() {
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }
        return grades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public void promoteToNextCourse() {
        this.course++;
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', group='%s', course=%d, grades=%s, avg=%.2f}",
                name, group, course, grades, getAverageGrade());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group) &&
                Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course, grades);
    }
}

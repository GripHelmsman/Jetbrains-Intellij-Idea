import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {
    private final String name;
    private final int age;
    private final double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }
}

public class StudentReport {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 20, 94.5));
        students.add(new Student("Brian", 21, 87.0));
        students.add(new Student("Clara", 19, 98.0));
        students.add(new Student("David", 22, 91.5));

        students.sort(
            Comparator.comparingDouble(Student::getScore).reversed()
        );

        double totalScore = 0;

        System.out.println("Student Report");
        System.out.println("==============");

        int position = 1;

        for (Student student : students) {
            System.out.printf(
                "%d. %s | Age: %d | Score: %.1f%n",
                position,
                student.getName(),
                student.getAge(),
                student.getScore()
            );

            totalScore += student.getScore();
            position++;
        }

        System.out.println("==============");
        System.out.printf("Average Score: %.2f%n", totalScore / students.size());
        System.out.println("Top Student: " + students.get(0).getName());
        System.out.printf("Top Score: %.1f%n", students.get(0).getScore());
    }
}
import java.util.ArrayList;

public class Student extends Person {
    private static int studentIdCounter = 1;
    private int studentId;
    private ArrayList<Integer> grades;

    public Student(String name, String surname, ArrayList<Integer> grades) {
        super(name, surname);
        this.studentId = studentIdCounter++;
        this.grades = new ArrayList<>(grades);
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return total / (double) grades.size();
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentId + " and GPA: " + String.format("%.2f", calculateGPA()) + ".";
    }


}

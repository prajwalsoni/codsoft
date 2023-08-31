package studentmanagement;

public class Student {
    private String name;
    private String rollNo;
    private String grade;

    public Student(String name, String rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}


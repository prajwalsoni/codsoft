package studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String rollNo) {
        students.removeIf(student -> student.getRollNo().equals(rollNo));
    }

    public Student searchStudent(String rollNo) {
        for (Student student : students) {
            if (student.getRollNo().equals(rollNo)) {
                return student;
            }
        }
        return null; // Student not found
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Return a copy to avoid modification from outside
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Add more methods for editing and other operations
}

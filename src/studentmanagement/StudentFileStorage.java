package studentmanagement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFileStorage {
    private String filePath;

    public StudentFileStorage(String filePath) {
        this.filePath = filePath;
    }

    public List<Student> readStudentsFromFile() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    String rollNo = parts[1];
                    String grade = parts[2];
                    Student student = new Student(name, rollNo, grade);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void writeStudentsToFile(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getRollNo() + "," + student.getGrade());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StudentFileStorage storage = new StudentFileStorage("students.txt");

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "101", "A"));
        students.add(new Student("Bob", "102", "B"));
        students.add(new Student("Carol", "103", "C"));

        storage.writeStudentsToFile(students);

        List<Student> loadedStudents = storage.readStudentsFromFile();
        for (Student student : loadedStudents) {
            System.out.println(student.getName() + " - " + student.getRollNo() + " - " + student.getGrade());
        }
    }
}


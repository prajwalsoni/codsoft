package studentmanagementl;
import java.util.Scanner;

public class ConsoleUI {
    private StudentManagementSystem system;
    private Scanner scanner;

    public ConsoleUI() {
        system = new StudentManagementSystem();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student roll number: ");
        String rollNo = scanner.nextLine();
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNo, grade);
        system.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private void removeStudent() {
        System.out.print("Enter student roll number to remove: ");
        String rollNo = scanner.nextLine();
        system.removeStudent(rollNo);
        System.out.println("Student removed successfully!");
    }

    private void searchStudent() {
        System.out.print("Enter student roll number to search: ");
        String rollNo = scanner.nextLine();
        Student student = system.searchStudent(rollNo);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private void displayAllStudents() {
        System.out.println("All students:");
        for (Student student : system.getAllStudents()) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.run();
    }
}

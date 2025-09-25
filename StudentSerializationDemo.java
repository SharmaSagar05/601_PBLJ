import java.io.*;
import java.util.Scanner;

// Step 1: Student class implementing Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private int studentID;
    private String name;
    private String grade;

    public Student(int studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
}

// Step 2: Main class
public class StudentSerializationDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        // Create Student object
        Student student = new Student(id, name, grade);
        String filename = "student.ser";

        // --- Serialization ---
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(student);
            System.out.println("\nStudent object has been serialized to " + filename);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- Deserialization ---
        Student deserializedStudent = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            deserializedStudent = (Student) in.readObject();
            System.out.println("\nStudent object has been deserialized.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Display deserialized student's data
        if (deserializedStudent != null) {
            deserializedStudent.displayStudentInfo();
        }

        scanner.close();
    }
}
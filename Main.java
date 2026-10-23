
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main()throws IOException{
         Scanner scanner = new Scanner(System.in); 
        RegistryManager manager = new RegistryManager();
        File file= new File("students.txt");
        FileReader fileReader =  new FileReader(file);
        System.out.println("Looking for file at: " + file.getAbsolutePath());
        manager.loadStudentsFromFile(file.getAbsolutePath());
        manager.displayAllStudents();
        FileWriter Writer= new FileWriter("student.txt");
        Writer.write("THIS IS ONLINE SESSION");
        Writer.write("THANK YOU FOR JOINING");
        Writer.write("MY NAME IS Esther");


        System.out.println("\n--- ADD NEW STUDENT ---");
        
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter Major: ");
        String major = scanner.nextLine();

        Student newStudent = new Student(id, name, gpa, major);
        FileWriter fileWriter = new FileWriter(file);

       // manager.addNewStudentToFile(file, NewStudent);
        System.out.println("\n--- UPDATED LIST ---");
        manager.loadStudentsFromFile(file.getAbsolutePath());
        manager.displayAllStudents();
        manager.groupStudentsByMajor();

        scanner.close();
    
    }
}
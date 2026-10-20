
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main()throws IOException{
        RegistryManager manager = new RegistryManager();
        File file= new File("students.txt");
        FileReader fileReader1 = new FileReader(file);
        System.out.println("Looking for file at: " + file.getAbsolutePath());

        manager.loadStudentsFromFile(file.getAbsolutePath());
        manager.displayAllStudents();
        manager.groupStudentsByMajor();
    }
}
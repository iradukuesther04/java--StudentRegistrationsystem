import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistryManager {
    private List<Student> students;

    public RegistryManager() {
        this.students = new ArrayList<>();
    }

    public void loadStudentsFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        boolean isFirstLine = true;

        while ((line = br.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0].trim());
            String name = parts[1].trim();
            double gpa = Double.parseDouble(parts[2].trim());
            String major = parts[3].trim();

            Student student = new Student(id, name, gpa, major);
            students.add(student);
        }
        br.close();
        System.out.println("Successfully loaded " + students.size() + " students from file.");
    }

    public void displayAllStudents() {
        System.out.println("--- ALL STUDENTS ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void groupStudentsByMajor() {
        System.out.println("--- GROUPED BY MAJOR ---");
        Map<String, List<String>> grouped = new HashMap<>();

        for (Student s : students) {
            grouped.computeIfAbsent(s.getMajor(), k -> new ArrayList<>()).add(s.getName());
        }

        for (Map.Entry<String, List<String>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
        }
    }
}

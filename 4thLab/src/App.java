import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            Scanner console = new Scanner(System.in);
            String path = console.nextLine();
            FileWriter Report = new FileWriter(path);
            int NumberOfStudents = scanner.nextInt();
            String line = scanner.nextLine();
            ExamRecords[] StudentsRecords = new ExamRecords[NumberOfStudents];
            for (int i = 0; i < NumberOfStudents; i++) {
                StudentsRecords[i] = new ExamRecords();
                StudentsRecords[i].input(scanner);
                StudentsRecords[i].output(Report);
                if (StudentsRecords[i].Excellent())
                    Report.write("Excellent student \n");
                else
                    Report.write("Not an excellent student \n");
                Report.write("\n");
            }
            Report.close();
        } catch (IOException exception) {
            System.out.println("File not open");
        }
    }
}
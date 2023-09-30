import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class ExamRecords {

    Student thisStudent = new Student();
    int NumberOfSessions;
    Session[] Sessions;

    public class Student {
        String Name;
        int Year;
        int Group;
        Boolean Excelling = true;

        public void input(Scanner scanner) {
            String line = scanner.nextLine();

            Name = "";
            String[] words = line.split("\\s+");

            for (int i = 0; i < 3; i++) {
                Name += words[i];
                Name += " ";
            }

            Year = Integer.parseInt(words[3]);
            Group = Integer.parseInt(words[4]);
        }

        public void output(FileWriter Out) throws IOException {
            Out.write(this.toString());
        }

        public String toString() {
            return Name + " year: " + Year + " group: " + Group + "\n";
        }

    }

    public boolean Excellent() {
        for (int i = 0; i < this.NumberOfSessions; i++)
            for (int j = 0; j < this.Sessions[i].ExamNumber; j++)
                if (this.Sessions[i].exams[j].Mark < 9)
                    return false;
        return true;
    }

    public class Session {
        int SessionNumber;
        int ExamNumber;
        Exam[] exams;

        public class Exam {

            String ExamName;
            int Mark;

            public void input(Scanner scanner) throws IOException {

                String line = scanner.nextLine();

                ExamName = "";
                int count = 0;
                String[] words = line.split("\\s+");
                for (String word : words) {
                    count++;
                }
                for (int i = 0; i < count - 1; i++) {
                    ExamName += words[i];
                    ExamName += " ";
                }

                Mark = Integer.parseInt(words[count - 1]);
            }

            public void output(FileWriter Out) throws IOException {
                Out.write(this.toString());
            }

            public String toString() {
                return this.ExamName + " " + this.Mark + "\n";
            }
        }

        public void input(Scanner scanner) throws IOException {
            SessionNumber = scanner.nextInt();
            ExamNumber = scanner.nextInt();
            String line = scanner.nextLine();

            exams = new Exam[ExamNumber];
            for (int i = 0; i < ExamNumber; i++) {
                exams[i] = new Exam();
                exams[i].input(scanner);
            }
        }

        public void output(FileWriter Out) throws IOException {
            for (int i = 0; i < ExamNumber; i++) {
                exams[i].output(Out);
            }
        }

    }

    public void input(Scanner scanner) throws IOException {
        thisStudent.input(scanner);
        NumberOfSessions = scanner.nextInt();
        String line = scanner.nextLine();
        Sessions = new Session[NumberOfSessions];

        for (int i = 0; i < NumberOfSessions; i++) {
            Sessions[i] = new Session();
            Sessions[i].input(scanner);
        }
    }

    public void output(FileWriter Out) throws IOException {
        thisStudent.output(Out);
        for (int i = 0; i < NumberOfSessions; i++) {
            Out.write(i + 1);
            Sessions[i].output(Out);
        }
    }
}
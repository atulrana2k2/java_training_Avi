import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class studentanalyzer3feb {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Enter Student Details");
            System.out.println("2. Analyze Marks");
            System.out.println("3. Find Top 5 Toppers");
            System.out.println("4. Segregate Students");
            System.out.println("5. Students Requiring Personal Attention");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    Student student = inputStudentDetails(sc);
                    if (student != null) {
                        students.add(student);
                    }
                    break;
                case "2":
                    analyzeMarks(students);
                    break;
                case "3":
                    findTopToppers(students);
                    break;
                case "4":
                    segregateStudents(students);
                    break;
                case "5":
                    studentsRequiringPersonalAttention(students);
                    break;
                case "6":
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    public static Student inputStudentDetails(Scanner sc) {
        System.out.println("Enter Student Name:");
        String Name = sc.nextLine();
        System.out.println("Enter the marks in English (out of 100) :");
        int EnglishM = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the marks in Maths (out of 100) :");
        int MathM = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the marks in Science (out of 100) :");
        int ScienceM = sc.nextInt();
        sc.nextLine();
        return new Student(Name, EnglishM, MathM, ScienceM);
    }

    public static void analyzeMarks(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students Data is available ");
            return;
        }
        for (Student student : students) {
            double average = student.getAverage();
            if (average > 85) {
                System.out.println(student.name + " is in A " + average);
            } else if (average >= 40 && average <= 85) {
                System.out.println(student.name + " is in B " + average);
            } else {
                System.out.println(student.name+ " is in C " + average);
            }
        }
    }

    public static void findTopToppers(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }
        Collections.sort(students, Collections.reverseOrder());
        System.out.println("Top 5 Toppers:");
        for (int i = 0; i < Math.min(5, students.size()); i++) {
            System.out.println(students.get(i));
        }
    }

    public static void segregateStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }
        List<Student> above85List = new ArrayList<>();
        List<Student> between85and40List = new ArrayList<>();
        List<Student> below40List = new ArrayList<>();
        for (Student student : students) {
            double average = student.getAverage();

            if (average > 85) {
                above85List.add(student);
            } else if (average >= 40) {
                between85and40List.add(student);
            } else {
                below40List.add(student);
            }
        }

        System.out.println("Students Above 85:");
        printStudents(above85List);

        System.out.println("Students Between 85 and 40:");
        printStudents(between85and40List);

        System.out.println("Students Below 40:");
        printStudents(below40List);
    }

    private static void printStudents(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public static void studentsRequiringPersonalAttention(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        System.out.println("Students Requiring Personal Attention:");
        int count=0;

        for (Student student : students) {
            if (student.requiresPersonalAttention()) {
                System.out.println(student);
                 count++;
            }

        }
        if(count==0)
            System.out.println("No student in personnel attention");
    }

    public static class Student implements Comparable<Student> {
        String name;
        int EnglishM;
        int MathM;
        int ScienceM;

        public Student(String name, int EnglishM, int MathM, int ScienceM) {
            this.name = name;
            this.EnglishM = EnglishM;
            this.MathM = MathM;
            this.ScienceM = ScienceM;
        }

        public double getAverage() {
            return (EnglishM + MathM + ScienceM) / 3.0;
        }

        public boolean requiresPersonalAttention() {
            return EnglishM < 33 || MathM < 33 || EnglishM < 33 || getAverage() < 40;
        }

        public int compareTo(Student other) {
            return Double.compare(this.getAverage(), other.getAverage());
        }

        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", EnglishMarks=" + EnglishM +
                    ", mathMarks=" + MathM +
                    ", scienceMarks=" + ScienceM +
                    ", average=" + getAverage() +
                    '}';
        }
    }
}

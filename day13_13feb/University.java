import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

abstract class Person                               //abstract class Person having different data members
{
   private int id;
    private String Name;
    private int age;

    public Person(int id, String name, int age) {               //Constructor to Person class
        this.id = id;
        Name = name;
        this.age = age;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return Name;
    }
    public int getAge(){
        return age;
    }
    abstract void getDetails();                                  //Abstracted Function
}
class Student extends Person{                                    //Class Student derived from Person class
    int studentId;
    List<String>courses=new ArrayList<>();

    public void enrollCourse(String course)                     //function to add course to an existing student
    {
        if(!courses.contains(course)) {
            courses.add(course);
            System.out.println("Course added successfully");
        }
        else
            System.out.println("Course already exist");
    }

    public Student(int id , String Name, int age,int studentId, List<String> courses) {     //constructor of class Student
       super(id,Name,age);
        this.studentId = studentId;
        this.courses = courses;
    }

      @Override
    public void getDetails()                                                    //override the getDetails function
    {
        System.out.println("Personal Id : "+getId());
        System.out.println("Student Name :"+getName());
        System.out.println("Student Age : "+getAge());
        System.out.println("Student Id : "+studentId);
        System.out.println("Student Studying Courses :"+courses);
    }
}
class Faculty extends Person                            //new class Faculty inherited from Person
{
    int employeId;
    String Department;

    public Faculty(int id, String name, int age, int employeId, String department) { //constructor of Faculty class
        super(id, name, age);
        this.employeId = employeId;
        Department = department;
    }

    public void getDetails()                                        //override method getDetails for Faculty class
    {
        System.out.println("Personal id : "+getId());
        System.out.println("Employee Name : "+getName());
        System.out.println("Employee Age : "+getAge());
        System.out.println("Employee Id of Person :"+employeId);
        System.out.println("Department of Employee : "+Department);
        System.out.println();
    }
}
class Courses
{
    private int coursecode;
   private String coursename;
  private  int credits;

    public Courses(int coursecode, String coursename, int credits) {        //Courses class constructor
        this.coursecode = coursecode;
        this.coursename = coursename;
        this.credits = credits;
    }
    public int getCourseCode(){                                         //returning the Private mem of the class using a member function

        return coursecode;
}
    public String getCoursename(){
        return coursename;
}
public int getCredits(){
        return credits;
}

}
public class University {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        List<Faculty> faculties = new ArrayList<>();            //Lists to store various objects of class Student Faculty Courses
        List<Courses> coursesList = new ArrayList<>();
        Courses course1 = new Courses(1, "DSA", 25);
        Courses course2 = new Courses(2, "ML-Python", 25);
        Courses course3 = new Courses(3, "Java-API", 25);
        coursesList.add(course1);
        coursesList.add(course2);
        coursesList.add(course3);
        while (true) {
            System.out.println("OPTIONS");
            System.out.println("1.add Student");
            System.out.println("2. remove Student");
            System.out.println("3. add faculty");
            System.out.println("4. remove faculty");
            System.out.println("5. add Course in the University");
            System.out.println("6. Remove course from University");
            System.out.println("7. Display Students");
            System.out.println("8. Display Faculty members");
            System.out.println("9. Display course in University");
            System.out.println("10. To add a course of a Student");
            System.out.println("11. To exit the system");
            System.out.println("Select from the OPTIONS");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Student student = addstudent(sc,coursesList);               //adding new student using a function
                    if (student != null) {
                        students.add(student);
                        System.out.println("Student added successfully");
                    }
                    break;
                case 2:                                                 //function to remove a student from the system
                    if (students.isEmpty()) {
                        System.out.println("No Student present");
                        break;
                    }
                    System.out.println("Enter the StudentID you want to remove :");
                    int Id = sc.nextInt();
                    boolean flag = false;
                    for (Student check : students) {
                        if (check.studentId == Id) {
                            students.remove(check);
                            System.out.println("Student with StudentId : " + Id + " is removed");
                            flag = true;
                            break;
                        }
                    }
                    if (!flag)
                        System.out.println("Enter StudentId not found in the System");
                    break;

                case 3:
                    Faculty teacher = addfaculty(sc);             //adding new faculty member using a function
                    if (teacher != null) {
                        faculties.add(teacher);
                        System.out.println("Faculty added successfully");
                    }
                case 4:                                         //removing faculty member
                    if (faculties.isEmpty()) {
                        System.out.println("No faculty member is present");
                        break;
                    }
                    System.out.println("Enter the Employee id  you want to remove");
                    int id = sc.nextInt();
                    boolean flag2 = false;
                    for (Faculty check : faculties) {
                        if (check.employeId == id) {
                            faculties.remove(check);
                            flag2 = true;
                            System.out.println("Employee is removed");
                            break;
                        }
                    }
                    if (flag2 == false)
                        System.out.println("Enterd Employee id does not exist in the system");
                case 5:
                    Courses courses = addcourse(sc);                //adding new course using a function
                    if (courses != null) {
                        coursesList.add(courses);
                        System.out.println("Course added successfully");
                    }
                    break;
                case 6:                                                 //removing a course from the system
                    if (coursesList.isEmpty()) {
                        System.out.println("No courses Present");
                        break;
                    }
                    System.out.println("Enter the course Id you want to remove:");
                    int rid = sc.nextInt();
                    boolean flag3 = false;
                    for (Courses course : coursesList) {
                        if (course.getCourseCode() == rid) {
                            coursesList.remove(course);
                            flag3 = true;
                            System.out.println("Course is removed");
                            break;
                        }
                    }
                    if (!flag3) {
                        System.out.println("Course with " + rid + " id  doesnot exist");
                    }
                    break;
                case 7:                                                         //Displaying the student in the system
                    if (students.isEmpty())
                        System.out.println(" No Student Present");
                    else
                        for (Student obj : students) {
                            obj.getDetails();
                            System.out.println();
                        }
                    break;
                case 8:                                                          //Displaying the faculty in the system
                    if (faculties.isEmpty()) {
                        System.out.println("No faculty present");
                    } else
                        for (Faculty obj : faculties) {
                            obj.getDetails();
                            System.out.println();
                        }
                    break;
                case 9:                                                     //Displaying the courses Present in the university
                    if (coursesList.isEmpty())
                        System.out.println("No course Present");
                    else
                        for (Courses obj : coursesList) {
                            System.out.println("Course code : "+obj.getCourseCode());
                            System.out.println("Course Name : "+obj.getCoursename());
                            System.out.println("Course Credits : "+obj.getCredits());
                            System.out.println();
                        }
                    break;
                case 10:                                                        //adding a course for a Student
                    if (students.isEmpty()) {
                        System.out.println("No Student present");
                        break;
                    }
                    System.out.println("Enter the StudentID you want to add course :");
                    int Idc = sc.nextInt();
                    System.out.println("Enter the course Your want to add:");
                    String cn = sc.next();
                    boolean flag4 = false;
                    for (Student check : students) {
                        if (check.studentId == Idc) {
                            check.enrollCourse(cn);
                            flag4 = true;
                            break;
                        }

                    }
                    if (flag4 == false) {
                        System.out.println("Student with StudentId " + Idc + " is not present");
                    }
                    break;
                case 11:
                    System.out.println("------->System Exiting<-------");
                    System.exit(0);

            }
        }
    }
        public static Student addstudent (Scanner sc,List<Courses> coursesList){
            System.out.println("Enter the Id:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Name");
            String Name = sc.next();
            sc.nextLine();
            System.out.println("Enter Your Age");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter your Student Id");
            int StudentId = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter number  of courses you want to select (out of :" +coursesList.size()+" )");
            int numbr = sc.nextByte();
            List<String> courses = new ArrayList<>();
            System.out.println("Select from the avliable courses in the University:");
            for(Courses course:coursesList)
                System.out.println(course.getCoursename());
            for (int i = 0; i < numbr; i++) {
                System.out.println("Enter your course " + (i + 1));
                String course = sc.next();
                for(Courses course1 : coursesList)
                {
                   if (course1.getCoursename().equalsIgnoreCase(course))
                   {
                       courses.add(course);
                        break;
                }

            }}

            sc.nextLine();
            return new Student(id, Name, age, StudentId, courses);              //returning new Student


        }
        public static Faculty addfaculty (Scanner sc)
        {
            System.out.println("Enter the Id");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Name");
            String name = sc.next();
            sc.nextLine();
            System.out.println("Enter the Age");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the EmployeeId");
            int employeId = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Department");
            String department = sc.next();
            sc.nextLine();
            return new Faculty(id, name, age, employeId, department);       //returning new faculty member


        }
        public static Courses addcourse (Scanner sc)
        {
            System.out.println("Enter the Course Id");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Course Name");
            String cName = sc.next();
            sc.nextLine();
            System.out.println("Enter the Course Credits");
            int credits = sc.nextInt();
            sc.nextLine();
            return new Courses(id, cName, credits);                       //returning new Course Object
        }
    }



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Employee interface
interface Employee {
    void addEmployee(int id, String name, String position, double salary, int monthsSinceJoining);
    void removeEmployee(int id);
    void displayEmployeeInfo(int id);
    void displayAllEmployees();
    void calculateTotalSalary();
    void sortEmployeesBySalary();
    void searchEmployees(String key);
    void updateEmployeeInfo(int id, String name, String position, double salary);
}

// FullTimeEmployee class implementing Employee interface
class FullTimeEmployee implements Employee {
    private ArrayList<FullTimeEmployee> employees;
    private int id;
    private String name;
    private String position;
    private double salary;
    private int monthsSinceJoining;

    FullTimeEmployee() {
        employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(int id, String name, String position, double salary, int monthsSinceJoining) {
        FullTimeEmployee employee = new FullTimeEmployee();
        employee.id = id;
        employee.name = name;
        employee.position = position;
        employee.salary = salary;
        employee.monthsSinceJoining = monthsSinceJoining;
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    @Override
    public void removeEmployee(int id) {
        for (FullTimeEmployee employee : employees) {
            if (employee.id == id) {
                employees.remove(employee);
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee with given ID not found.");
    }

    @Override
    public void displayEmployeeInfo(int id) {
        for (FullTimeEmployee employee : employees) {
            if (employee.id == id) {
                System.out.println("Employee ID: " + employee.id);
                System.out.println("Name: " + employee.name);
                System.out.println("Position: " + employee.position);
                System.out.println("Salary: " + employee.salary);
                System.out.println("Months Since Joining: " + employee.monthsSinceJoining);
                return;
            }
        }
        System.out.println("Employee with given ID not found.");
    }

    @Override
    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (FullTimeEmployee employee : employees) {
            System.out.println("Employee ID: " + employee.id);
            System.out.println("Name: " + employee.name);
            System.out.println("Position: " + employee.position);
            System.out.println("Salary: " + employee.salary);
            System.out.println("Months Since Joining: " + employee.monthsSinceJoining);
            System.out.println("-------------------------");
        }
    }

    @Override
    public void calculateTotalSalary() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int idToCalculate = scanner.nextInt();

        // Check if the employee with the given ID exists
        boolean found = false;
        for (FullTimeEmployee employee : employees) {
            if (employee.id == idToCalculate) {
                found = true;
                double totalSalary = employee.salary * employee.monthsSinceJoining;
                System.out.println("Total Salary for Employee ID " + idToCalculate +" "+ employee.name +":"+ totalSalary);
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + idToCalculate + " not found.");
        }
    }

    @Override
    public void sortEmployeesBySalary() {
        Collections.sort(employees, Comparator.comparingDouble(employee -> employee.salary));
        System.out.println("Employees sorted by salary.");
    }

    @Override
    public void searchEmployees(String key) {
        boolean found = false;
        for (FullTimeEmployee employee : employees) {
            if (employee.name.equalsIgnoreCase(key) || employee.position.equalsIgnoreCase(key)
                    || String.valueOf(employee.salary).equalsIgnoreCase(key)) {
                System.out.println("Employee ID: " + employee.id);
                System.out.println("Name: " + employee.name);
                System.out.println("Position: " + employee.position);
                System.out.println("Salary: " + employee.salary);
                System.out.println("Months Since Joining: " + employee.monthsSinceJoining);
                System.out.println("-------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employee found matching the search criteria.");
        }
    }

    @Override
    public void updateEmployeeInfo(int id, String name, String position, double salary) {
        for (FullTimeEmployee employee : employees) {
            if (employee.id == id) {
                employee.name = name;
                employee.position = position;
                employee.salary = salary;
                System.out.println("Employee information updated successfully.");
                return;
            }
        }
        System.out.println("Employee with given ID not found.");
    }
}

// Main class
public class employeeManagement11_feb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FullTimeEmployee employeeManager = new FullTimeEmployee();

        while (true) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display Employee Information");
            System.out.println("4. Display All Employees");
            System.out.println("5. Calculate Total Salary");
            System.out.println("6. Sort Employees by Salary");
            System.out.println("7. Search Employees");
            System.out.println("8. Update Employee Information");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter Months Since Joining: ");
                    int monthsSinceJoining = scanner.nextInt();
                    employeeManager.addEmployee(id, name, position, salary, monthsSinceJoining);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    employeeManager.removeEmployee(removeId);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to display information: ");
                    int displayId = scanner.nextInt();
                    employeeManager.displayEmployeeInfo(displayId);
                    break;
                case 4:
                    employeeManager.displayAllEmployees();
                    break;
                case 5:
                    employeeManager.calculateTotalSalary();
                    break;
                case 6:
                    employeeManager.sortEmployeesBySalary();
                    break;
                case 7:
                    System.out.print("Enter name, position, or salary to search: ");
                    String key = scanner.next();
                    employeeManager.searchEmployees(key);
                    break;

                case 8:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String updatedName = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String updatedPosition = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double updatedSalary = scanner.nextDouble();
                    employeeManager.updateEmployeeInfo(updateId, updatedName, updatedPosition, updatedSalary);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 9.");
            }
        }
    }
}

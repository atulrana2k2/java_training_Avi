package org.example;



public class Employee {
    String FirstName;
    String LastName;
    String salary;

    public Employee( String firstName,
                     String lastName,
                     String salary) {
        FirstName = firstName;
        LastName = lastName;
        this.salary = salary;
    }
    public String toString() {
        return this.FirstName+" "+this.LastName+" "+this.salary;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}



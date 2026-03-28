// Assignment 02: Hierarchical Inheritance in Java
//Godwin Thomas, Roll No - 41, 1032240162


class Employee {
    protected double salary;

    Employee(double salary) {
        this.salary = salary;
    }

    void displaySalary(String type) {
        System.out.println(type + " Salary : " + salary);
    }
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(double salary) {
        super(salary);
    }

    void calculateSalary() {
        salary = salary + (salary * 0.50);
    }
}

class InternEmployee extends Employee {

    InternEmployee(double salary) {
        super(salary);
    }

    void calculateSalary() {
        salary = salary + (salary * 0.25);
    }
}

public class Assignment02 {
    public static void main(String[] args) {

        FullTimeEmployee fte = new FullTimeEmployee(40000);
        InternEmployee ie = new InternEmployee(20000);

        System.out.println("Before Hike:");
        fte.displaySalary("Full Time Employee");
        ie.displaySalary("Intern Employee");

        fte.calculateSalary();
        ie.calculateSalary();

        System.out.println("\nAfter Hike:");
        fte.displaySalary("Full Time Employee");
        ie.displaySalary("Intern Employee");
    }
}

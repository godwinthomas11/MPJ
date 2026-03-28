// Assignment 1b: Demonstration of Class, Object, Methods, Constructors, Access Specifiers

class Student {

    // private data members (encapsulation)
    private int rollNo;
    private String name;
    private double marks;

    // Constructor
    public Student(int r, String n, double m) {
        rollNo = r;
        name = n;
        marks = m;
    }

    // Method with return value
    public String getGrade() {
        if (marks >= 75)
            return "Distinction";
        else if (marks >= 60)
            return "First Class";
        else if (marks >= 50)
            return "Second Class";
        else
            return "Fail";
    }

    // Method with parameters
    public void updateMarks(double newMarks) {
        marks = newMarks;
    }

    // Method to display student details
    public void displayInfo() {
        System.out.println("Roll No   : " + rollNo);
        System.out.println("Name      : " + name);
        System.out.println("Marks     : " + marks);
        System.out.println("Grade     : " + getGrade());
    }
}

public class Assignment1b {
    public static void main(String[] args) {

        // Object creation
        Student s1 = new Student(101, "Godwin Thomas", 82.5);

        // Display details
        s1.displayInfo();

        // Updating marks using method
        s1.updateMarks(68.0);

        System.out.println("\nAfter Updating Marks:");
        s1.displayInfo();
    }
}

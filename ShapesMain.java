import java.util.Scanner;

class Shapes {

    // Method Overloading: same name 'area', different parameters

    // Area of Circle
    double area(double radius) {
        if (radius <= 0) {
            System.out.println("Error: Radius must be positive.");
            return -1;
        }
        return Math.PI * radius * radius;
    }

    // Area of Rectangle
    double area(double length, double breadth) {
        if (length <= 0 || breadth <= 0) {
            System.out.println("Error: Dimensions must be positive.");
            return -1;
        }
        return length * breadth;
    }

    // Area of Triangle
    double area(double base, double height, String type) {
        if (base <= 0 || height <= 0) {
            System.out.println("Error: Dimensions must be positive.");
            return -1;
        }
        return 0.5 * base * height;
    }
}

// Constructor Overloading: same class name, different params
class ShapesConstructor {

    double result;

    ShapesConstructor() {
        result = 0;
        System.out.println("Default shape created.");
    }

    ShapesConstructor(double radius) {
        result = Math.PI * radius * radius;
        System.out.printf("Circle Area (via constructor) = %.2f%n", result);
    }

    ShapesConstructor(double length, double breadth) {
        result = length * breadth;
        System.out.printf("Rectangle Area (via constructor) = %.2f%n", result);
    }
}

public class ShapesMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Shapes s = new Shapes();
        int choice;

        System.out.println("===== Shape Area Calculator =====");
        System.out.println("Demonstrating Constructor Overloading:");
        new ShapesConstructor();
        new ShapesConstructor(7.0);
        new ShapesConstructor(5.0, 3.0);

        System.out.println("\nDemonstrating Method Overloading (User Input):");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            double result;

            switch (choice) {
                case 1:
                    System.out.print("Enter radius: ");
                    double r = sc.nextDouble();
                    result = s.area(r);
                    if (result != -1)
                        System.out.printf("Circle Area = %.2f%n", result);
                    break;

                case 2:
                    System.out.print("Enter length: ");
                    double l = sc.nextDouble();
                    System.out.print("Enter breadth: ");
                    double b = sc.nextDouble();
                    result = s.area(l, b);
                    if (result != -1)
                        System.out.printf("Rectangle Area = %.2f%n", result);
                    break;

                case 3:
                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();
                    System.out.print("Enter height: ");
                    double height = sc.nextDouble();
                    result = s.area(base, height, "triangle");
                    if (result != -1)
                        System.out.printf("Triangle Area = %.2f%n", result);
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
import java.util.Scanner;

class Hillstations {

    void famousfood() {
        System.out.println("General hillstation food information.");
    }

    void famousfor() {
        System.out.println("General hillstation information.");
    }
}

class Mahabaleshwar extends Hillstations {

    @Override
    void famousfood() {
        System.out.println("Mahabaleshwar: Famous for fresh Strawberries, Corn, and Mulberry.");
    }

    @Override
    void famousfor() {
        System.out.println("Mahabaleshwar: Famous for scenic viewpoints, Arthur's Seat, and lush valleys.");
    }
}

class Lonavala extends Hillstations {

    @Override
    void famousfood() {
        System.out.println("Lonavala: Famous for Chikki, Fudge, and Wax Chocolate.");
    }

    @Override
    void famousfor() {
        System.out.println("Lonavala: Famous for Bhushi Dam, Karla Caves, and monsoon waterfalls.");
    }
}

class Ooty extends Hillstations {

    @Override
    void famousfood() {
        System.out.println("Ooty: Famous for Nilgiri Tea, Homemade Chocolate, and Varkey.");
    }

    @Override
    void famousfor() {
        System.out.println("Ooty: Famous for Nilgiri hills, Ooty Lake, and the UNESCO toy train.");
    }
}

public class HillMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        // Parent class reference — key to runtime polymorphism
        Hillstations h;

        System.out.println("===== Hill Station Explorer =====");

        do {
            System.out.println("\n--- Select a Hill Station ---");
            System.out.println("1. Mahabaleshwar");
            System.out.println("2. Lonavala");
            System.out.println("3. Ooty");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    h = new Mahabaleshwar();   // Parent ref -> Child object
                    System.out.println("\n-- Mahabaleshwar --");
                    h.famousfood();            // Overridden method called at runtime
                    h.famousfor();
                    break;

                case 2:
                    h = new Lonavala();
                    System.out.println("\n-- Lonavala --");
                    h.famousfood();
                    h.famousfor();
                    break;

                case 3:
                    h = new Ooty();
                    System.out.println("\n-- Ooty --");
                    h.famousfood();
                    h.famousfor();
                    break;

                case 4:
                    System.out.println("Thank you for exploring!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
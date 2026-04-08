import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

// Custom Exceptions
class MinimumBalanceException extends Exception {
    MinimumBalanceException(String msg) {
        super(msg);
    }
}

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String msg) {
        super(msg);
    }
}

class InvalidCidException extends Exception {
    InvalidCidException(String msg) {
        super(msg);
    }
}

class NegativeAmountException extends Exception {
    NegativeAmountException(String msg) {
        super(msg);
    }
}

public class BankingSystem {

    static Scanner sc = new Scanner(System.in);

    // Global customer data (just one customer for simplicity)
    static int cid;
    static String cname;
    static double balance;
    static boolean accountCreated = false;

    // ---- Create Account ----
    static void createAccount() {
        try {
            System.out.print("Enter Customer ID (1 to 20): ");
            cid = sc.nextInt();
            if (cid < 1 || cid > 20) {
                throw new InvalidCidException("CID must be between 1 and 20.");
            }

            System.out.print("Enter Customer Name: ");
            cname = sc.next();

            System.out.print("Enter Initial Amount: ");
            balance = sc.nextDouble();

            if (balance <= 0) {
                throw new NegativeAmountException("Amount must be positive.");
            }
            if (balance < 1000) {
                throw new MinimumBalanceException("Minimum deposit is Rs. 1000.");
            }

            accountCreated = true;
            saveToFile();
            System.out.println("Account created successfully!");

        } catch (InvalidCidException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NegativeAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (MinimumBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // ---- Deposit ----
    static void deposit() {
        try {
            System.out.print("Enter deposit amount: ");
            double amt = sc.nextDouble();

            if (amt <= 0) {
                throw new NegativeAmountException("Amount must be positive.");
            }

            balance = balance + amt;
            System.out.println("Deposit successful. New balance: Rs." + balance);

        } catch (NegativeAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ---- Withdraw ----
    static void withdraw() {
        try {
            System.out.print("Enter withdrawal amount: ");
            double amt = sc.nextDouble();

            if (amt <= 0) {
                throw new NegativeAmountException("Amount must be positive.");
            }
            if (amt > balance) {
                throw new InsufficientFundsException("Not enough balance. Current balance: Rs." + balance);
            }

            balance = balance - amt;
            System.out.println("Withdrawal successful. Remaining balance: Rs." + balance);

        } catch (NegativeAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ---- Save to File ----
    static void saveToFile() throws IOException {
        FileWriter fw = new FileWriter("customers.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("CID: " + cid + " | Name: " + cname + " | Balance: Rs." + balance);
        bw.newLine();
        bw.close();
        System.out.println("Record saved to customers.txt");
    }

    // ---- Display from File ----
    static void displayFromFile() {
        try {
            FileReader fr = new FileReader("customers.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            System.out.println("\n-- Customer Records --");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // ---- Main Menu ----
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Records from File");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                createAccount();
            } else if (choice == 2) {
                if (!accountCreated) {
                    System.out.println("Please create an account first.");
                } else {
                    deposit();
                }
            } else if (choice == 3) {
                if (!accountCreated) {
                    System.out.println("Please create an account first.");
                } else {
                    withdraw();
                }
            } else if (choice == 4) {
                if (!accountCreated) {
                    System.out.println("No account found.");
                } else {
                    System.out.println("Balance: Rs." + balance);
                }
            } else if (choice == 5) {
                displayFromFile();
            } else if (choice == 6) {
                System.out.println("Exiting. Goodbye!");
            } else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private String description;
    private double amount;
    private String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}

class ExpenseTracker {
    private List<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(String description, double amount, String category) {
        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to display.");
        } else {
            System.out.println("Expense List:");
            for (Expense expense : expenses) {
                System.out.println("Description: " + expense.getDescription());
                System.out.println("Amount: Rs" + expense.getAmount());
                System.out.println("Category: " + expense.getCategory());
                System.out.println("----------------------");
            }
        }
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter expense description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter expense amount: Rs");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter expense category: ");
                    String category = scanner.nextLine();
                    tracker.addExpense(description, amount, category);
                    break;
                case 2:
                    tracker.viewExpenses();
                    break;
                case 3:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

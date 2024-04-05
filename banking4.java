import java.util.Scanner;

class banking4 {
    static int accountNumberCounter = 123456789;

    static class Account {
        String name;
        String address;
        String contactInfo;
        int balance;
        int accountNumber;

        Account(String name, String address, String contactInfo, int balance) {
            this.name = name;
            this.address = address;
            this.contactInfo = contactInfo;
            this.balance = balance;
            this.accountNumber = accountNumberCounter++;
        }

        void deposit(int amount) {
            balance += amount;
            System.out.println("Deposited " + amount + " successfully.");
            displayBalance();
        }

        boolean withdraw(int amount) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn " + amount + " successfully.");
                displayBalance();
                return true;
            } else {
                System.out.println("Insufficient balance.");
                displayBalance();
                return false;
            }
        }

        void displayBalance() {
            System.out.println("Current Balance: " + balance);
        }

        void displayAccountInfo() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("Contact Info: " + contactInfo);
            displayBalance();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Banking Information System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    performDeposit(scanner);
                    break;
                case 3:
                    performWithdraw(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.println("Enter Name: ");
        String name = scanner.next();
        System.out.println("Enter Address: ");
        String address = scanner.next();
        System.out.println("Enter Contact Info: ");
        String contactInfo = scanner.next();
        System.out.println("Enter Initial Balance: ");
        int balance = scanner.nextInt();
        Account account = new Account(name, address, contactInfo, balance);
        System.out.println("Account Created Successfully.");
        account.displayAccountInfo();
    }

    private static void performDeposit(Scanner scanner) {
        System.out.println("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        
        Account account = new Account("John Doe", "123 Main St", "1234567890", 1000);
        System.out.println("Enter Amount to Deposit: ");
        int amount = scanner.nextInt();
        account.deposit(amount);
    }

    private static void performWithdraw(Scanner scanner) {
        System.out.println("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
 
        Account account = new Account("John Doe", "123 Main St", "1234567890", 1000);
        System.out.println("Enter Amount to Withdraw: ");
        int amount = scanner.nextInt();
        account.withdraw(amount);
    }
}

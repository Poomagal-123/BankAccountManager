import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccountManager manager = new BankAccountManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== BANK ACCOUNT MANAGER =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. List All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> manager.createAccount();
                case 2 -> manager.depositMoney();
                case 3 -> manager.withdrawMoney();
                case 4 -> manager.checkBalance();
                case 5 -> manager.listAllAccounts();
                case 6 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}

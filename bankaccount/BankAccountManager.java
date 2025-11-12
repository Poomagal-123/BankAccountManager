import java.util.HashMap;
import java.util.Scanner;

public class BankAccountManager {
    private HashMap<String, BankAccount> accounts = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists!");
            return;
        }

        System.out.print("Enter Customer ID: ");
        String custId = sc.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        Customer customer = new Customer(custId, name, email, phone);

        System.out.print("Enter Initial Deposit: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        BankAccount newAcc = new BankAccount(accNo, customer, amount);
        accounts.put(accNo, newAcc);
        System.out.println("✅ Account created successfully!");
    }

    public void depositMoney() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        BankAccount acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        acc.deposit(amount);
    }

    public void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        BankAccount acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter Withdraw Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        acc.withdraw(amount);
    }

    public void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        BankAccount acc = accounts.get(accNo);
        if (acc != null) {
            acc.displayAccountDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    public void listAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found!");
            return;
        }
        for (BankAccount acc : accounts.values()) {
            System.out.println("------------------------");
            acc.displayAccountDetails();
        }
    }
}

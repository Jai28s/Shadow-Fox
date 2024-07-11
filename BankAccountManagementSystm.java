import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: +" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrawal: -" + amount);
        } else {
            System.out.println("Insufficient balance. Withdrawal not permitted.");
        }
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History for Account " + accountNumber);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

public class BankAccountManagementSystm {
    private List<Account> accounts;

    public BankAccountManagementSystm() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BankAccountManagementSystm bankSystem = new BankAccountManagementSystm();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter account number: ");
            String accountNumber = scanner.next();
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();

            Account newAccount = new Account(accountNumber, initialBalance);
            bankSystem.addAccount(newAccount);

            System.out.println("Account created successfully!");

            // Example usage
            Account foundAccount = bankSystem.findAccount(accountNumber);
            if (foundAccount != null) {
                System.out.println("Account found: " + foundAccount.getAccountNumber());

                while (true) {
                    System.out.println("\nChoose an action:");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdrawal");
                    System.out.println("3. View Transaction History");
                    System.out.println("4. Check Balance");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");
                    int actionChoice = scanner.nextInt();

                    switch (actionChoice) {
                        case 1:
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            foundAccount.deposit(depositAmount);
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawalAmount = scanner.nextDouble();
                            foundAccount.withdraw(withdrawalAmount);
                            break;
                        case 3:
                            foundAccount.viewTransactionHistory();
                            break;
                        case 4:
                            System.out.println("Current balance: $" + foundAccount.getBalance());
                            break;
                        case 0:
                            System.out.println("Exiting the system. Goodbye!");
                            scanner.close();
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 0.");
                    }
                }
            } else {
                System.out.println("Account not found.");
            }
        }
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}

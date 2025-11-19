import java.util.Scanner;

class Account {
    String name;
    int accountNumber;
    int balance;

    void createAccount(String n, int accNo, int bal) {
        name = n;
        accountNumber = accNo;
        balance = bal;
    }

    void deposit(int amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[100];
        int accountCount = 0;
        int choice;

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.next();

                System.out.print("Enter account number: ");
                int accNo = sc.nextInt();

                boolean exists = false;
                for (int i = 0; i < accountCount; i++) {
                    if (accounts[i].accountNumber == accNo) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("Account number already exists! Try again.");
                    continue;
                }

                System.out.print("Enter opening balance: ");
                int bal = sc.nextInt();

                accounts[accountCount] = new Account();
                accounts[accountCount].createAccount(name, accNo, bal);
                accountCount++;

                System.out.println("Account created successfully!");

            } else if (choice == 2) {
                System.out.print("Enter account number: ");
                int accNo = sc.nextInt();

                boolean found = false;
                for (int i = 0; i < accountCount; i++) {
                    if (accounts[i].accountNumber == accNo) {
                        System.out.print("Enter amount: ");
                        int amt = sc.nextInt();
                        accounts[i].deposit(amt);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Account not found!");
                }

            } else if (choice == 3) {
                System.out.print("Enter account number: ");
                int accNo = sc.nextInt();

                boolean found = false;
                for (int i = 0; i < accountCount; i++) {
                    if (accounts[i].accountNumber == accNo) {
                        System.out.print("Enter amount: ");
                        int amt = sc.nextInt();
                        accounts[i].withdraw(amt);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Account not found!");
                }

            } else if (choice == 4) {
                System.out.print("Enter account number: ");
                int accNo = sc.nextInt();

                boolean found = false;
                for (int i = 0; i < accountCount; i++) {
                    if (accounts[i].accountNumber == accNo) {
                        accounts[i].checkBalance();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Account not found!");
                }

            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}

import java.util.Scanner;
public class BankAccountDetails1 {
    private int accountId;
    private String accountName;
    private double balance;
    private boolean savingsAccount;

    public BankAccountDetails1(int accountId, String accountName, double balance, boolean savingsAccount) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
        this.savingsAccount = isSavingsAccount(balance);
    }

    public boolean isSavingsAccount(double balance) {
        if (balance >= 25000) return false;
        else if (balance >= 10000) return true;
        else {
            System.out.println("Amount is "+balance+" try with minimum Amount that is 10,000 ");
            System.exit(0);
        }
        return false;
    }

    public void deposit(double value) {
        this.balance = this.balance + value;
        System.out.println("Amount Deposited successfully: " + value);
    }

    public void withdraw(double value) {
        if (value < 0) {
            System.out.println("Invalid amount");
        } else if (value > balance) {
            System.out.println("You can't withdraw this amount");
        } else {
            balance = balance - value;
            System.out.println("Withdraw amount" + value + "new balance" + balance);
        }
    }

    public void displayBankAccount() {
//        System.out.println("Account Name " + accountName);
       // System.out.println("Account Balance " + balance);
       // System.out.println("Account SavingsAccount true/false ? " + savingsAccount);
		System.out.printf("| %-10d | %-20s | %-13.2f | %-15s |\n",
                accountId, accountName, balance, savingsAccount ? "Yes" : "No");

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BankAccountDetails1[] bankDetails = new BankAccountDetails1[0];
        int insert;
        do {
            System.out.println("choose option");
            System.out.println("1. How many account you want enter?");
            System.out.println("2. Display bank account details");
            System.out.println("3. Deposit money ");
            System.out.println("4. Withdraw money");
            System.out.println("5. Exit the program ");

            insert = sc.nextInt();
            switch (insert) {
                case 1:
                    System.out.println("Enter how many accounts needed : ");
                    int size = sc.nextInt();
                    bankDetails=new BankAccountDetails1
					[size];
                    for (int i = 0; i < size; i++) {
                        System.out.println("Enter account Id ");
                        int accountId = sc.nextInt();
                        System.out.println("Enter account name : ");
                        String accountName = sc.next();
                        System.out.println("Enter account balance :");
                        double balance = sc.nextDouble();
                        System.out.println("Is it saving's account ? ");
                        boolean savingsAccount = sc.nextBoolean();
                        bankDetails[i] = new BankAccountDetails1(accountId, accountName, balance, savingsAccount);
                    }
                    System.out.println("Successfully " + size + " records inserted");
                    break;
                case 2:
                     System.out.println("Displaying the Bank Details");
					 System.out.println("---------------------------------------------------------------");
                     System.out.printf("| %-10s | %-20s | %-13s | %-15s |\n",
                      "Account ID", "Account Name", "Balance", "Savings Account");
                     System.out.println("---------------------------------------------------------------");
                    for (BankAccountDetails1 bankDetail : bankDetails)
                       bankDetail.displayBankAccount();
                     System.out.println("---------------------------------------------------------------");
                   break;
                case 3:
                    System.out.println("Enter Bank AccountId ");
                    int accountId = sc.nextInt();
                    System.out.println("Enter Deposit Amount ");
                    double depositAmount = sc.nextDouble();
                    for (BankAccountDetails1 bankDetail : bankDetails) {
                        boolean accountValidated = (accountId == bankDetail.accountId);

                        if (accountValidated) {
                            bankDetail.deposit(depositAmount);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter Bank AccountId ");
                    int id = sc.nextInt();
                    System.out.println("Enter WithDraw Amount ");
                    double withDrawAmount = sc.nextDouble();
                    for (BankAccountDetails1 bankDetail : bankDetails) {
                        boolean accountValidated = (id == bankDetail.accountId);

                        if (accountValidated) {
                            bankDetail.deposit(withDrawAmount);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Stopping the Bank Application");
                    return;


            }
        } while (true);
    }
}
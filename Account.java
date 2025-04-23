import java.util.Scanner;
public class Account{
	private int accountId;
	private String accountName;
	private double balance;
	private boolean savingAccount;
	
	public Account(int accountId, String accountName, double balance, boolean savingAccount){
		this.accountId = accountId;
	    this.accountName = accountName;
        this.balance = balance;
	    this.savingAccount = isSavingAccount(balance);
	}
	
	public boolean isSavingAccount(double balance){
		if(balance>=25000) return false;
		else if (balance>=10000) return true;
		else return false;
	}
	
	public void displayAccount(){
		System.out.println("Account detail");
		System.out.println("Account ID");
		System.out.println("Account Name");
		System.out.println("balance");
		System.out.println("SavingAccount yes/no");
		System.out.println();
		System.out.println(this.accountId);
		System.out.println(this.accountName);
		System.out.println(this.balance);
		System.out.println(this.savingAccount);
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many account details you want enter?");
		int size = sc.nextInt();
		Account[] account = new Account[size];
		for(int i=0; i<size; i++){
			System.out.println("Enter Account ID");
			int accountId =sc.nextInt();
		    System.out.println("Enter Account Name");
			String accountName = sc.next();
		    System.out.println("Enter balance");
			double balance = sc.nextDouble();
		    System.out.println("Enter SavingAccount true /false");
			boolean savingAccount = sc.nextBoolean();
			
			account[i] = new Account(accountId, accountName, balance,savingAccount);
		}
		for(int i =0; i<size; i++){
			account[i].displayAccount();
			
		}
		
	}
	
	
}
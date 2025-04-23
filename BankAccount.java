import java.util.Scanner;
public class BankAccount{
	private int accountId;
    private String	accountName; 
	private double balance;
	private boolean savingaccount;
	
	public BankAccount(int accountId,String	accountName, double balance,boolean savingaccount ){
	   this.accountId = accountId;
       this.accountName=accountName; 
       this.balance= balance;
	   this.savingaccount= isSavingaccount(balance);
		
	}
	
    public boolean isSavingaccount(double balance){
		if(balance>=25000) return false;
		else if (balance>=10000) return true;
		else return false;
	}
	public void deposit(double value){
		balance= balance+value;
		System.out.println("deposit"+ value);
	
	}
	
    public void withdraw(double value){
		if( value < 0){
			System.out.println("Invalid amount");
		}else if(value > balance){
			System.out.println("you can't withdraw this amount");
		}
		else{
			balance = balance - value;
			System.out.println("withdraw amount"+value+ " new balance"+ balance);
		}
	}
	
	public void  displayAccount(){
		System.out.println("Account detail");
		System.out.println("Account ID");
		System.out.println("Account Name");
		System.out.println("balance");
		System.out.println("SavingAccount yes/no");
		System.out.println();
		System.out.println(this.accountId);
		System.out.println(this.accountName);
		System.out.println(this.balance);
		System.out.println(this.savingaccount);
		
	}
	public static void main(String args[]){
		BankAccount account = new BankAccount(123, "Ramesh", 1200, false);
        account.displayAccount();	 
        account.deposit(5000);
        account.displayAccount();	
        account.withdraw(2000);	
        account.displayAccount();			
		
	}
}
//create BankAccount
    //accountId, accountName, balance,currentaccount or savingaccount
//for saving account flag should true otherwise false.
        
        //for saving account minimum balance is 10,000; current 25,000;
//print the data in table format id,name,balance,flag
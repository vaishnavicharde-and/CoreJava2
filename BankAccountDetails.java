import java.util.Scanner;
public class BankAccountDetails{
	private int accountId;
    private String	accountName; 
	private double balance;
	private boolean savingaccount;
	
	public BankAccountDetails(int accountId,String	accountName, double balance,boolean savingaccount){
		this.accountId= accountId;
		this.accountName = accountName;
		this.balance =balance;
		this.savingaccount =  savingaccount;
		
	}
	public boolean isSavingAccount(double balance){
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
	public int getAccountId() {
        return accountId;
    }
	public void displayBankAccount(){
		System.out.println("Account Id");
		System.out.println("Account Name");
		System.out.println("Account Balance");
		System.out.println("Account savingaccount true/false ?");
		System.out.print("");
		System.out.println(this.accountId);
		System.out.println(this.accountName);
		System.out.println(this.balance);
		System.out.println(this.savingaccount);
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		BankAccountDetails[] bank = null;
		int insert;
		int size = 0;
		do{
			System.out.println("choose option");
			System.out.println("1. How many account you want enter?");
			System.out.println("2. Display bank account details");
			System.out.println("3. Deposit money ");
			System.out.println("4. Withdraw money");
			System.out.println("5. Exit the program ");
	
			insert = sc.nextInt();
		switch(insert){
			case 1: 
			System.out.println("enter how many account want?");
			size = sc.nextInt();
			bank = new BankAccountDetails[size];
			for(int i=0; i<size; i++){
				System.out.println("Enter Account Id");
				int accountId = sc.nextInt();
		        System.out.println("Enter Account Name");
				String accountName = sc.next();
		        System.out.println("Enter Account Balance");
				double balance = sc.nextDouble();
		        System.out.println("Enter Account savingaccount true/false ?");
				boolean savingaccount = sc.nextBoolean();
				bank[i] = new BankAccountDetails(accountId, accountName,balance,savingaccount);
			}
			System.out.println("Bank account details enter successfully.");
			break;
			case 2:
			for(int i=0;i<size; i++){
				bank[i].displayBankAccount();
			}
			break;
			case 3:
			
			System.out.println("Enter Account Id for deposit:");
            int depositId = sc.nextInt();
            System.out.println("Enter deposit amount:");
            double depositAmount = sc.nextDouble();
            boolean depositFound = false;
            for (BankAccountDetails b : bank) {
            if (b.getAccountId() == depositId) {
            b.deposit(depositAmount);
            depositFound = true;
            break;
            }
            }
           if (!depositFound) {
           System.out.println("Account ID not found.");
            }
			break;
			case 4:
			System.out.println("Enter Account Id for withdrawal:");
                    int withdrawId = sc.nextInt();
                    System.out.println("Enter withdraw amount:");
                    double withdrawAmount = sc.nextDouble();
                    boolean withdrawFound = false;
                    for (BankAccountDetails b : bank) {
                        if (b.getAccountId() == withdrawId) {
                            b.withdraw(withdrawAmount);
                            withdrawFound = true;
                            break;
                        }
                    }
                    if (!withdrawFound) {
                        System.out.println("Account ID not found.");
                    }
                    break;
		
			case 5 :
	        System.out.println("Exit the program ");
		    return;
           default: 
	        System.out.println("option not exit");
		
			
			
		}
			
			
		}while(true);
		
		
	}
}
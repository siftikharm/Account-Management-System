/**
 * @author Iftikhar Mehdi , 19I-0657
 * Advanced Programming Task 01 : Account Management System
 * Class : Checkings Account
 * Date: 12th Sept , 2021
 */


package bank;

public class CheckingsAccount extends BankAccount{
	
	private float Tax;
	private float totalTransactionFees;
	
	public CheckingsAccount() {
		this.Tax = 0;
		this.totalTransactionFees = 0;
	}
	
	public CheckingsAccount(Customer customer) {
		super(customer);
		this.customer = customer;
		this.Tax = 0;
		this.totalTransactionFees = 0;
	}
	
	public CheckingsAccount(float tax , float ttf) {
		this.Tax = tax;
		this.totalTransactionFees = ttf;
	}

	public float getTax() {
		return this.Tax;
	}

	public void setTax(float tax) {
		this.Tax = tax;
	}
	
	public float getTotalTransactionFees() {
		return totalTransactionFees;
	}

	public void setTotalTransactionFees(float totalTransactionFees) {
		this.totalTransactionFees = totalTransactionFees;
	}

	@Override
	protected float makeWithdrawl(float amount) {
		if(amount < 0)
			throw new IllegalArgumentException("Withdrawing amount cannot be negative");
		
		if(amount > this.customer.getBalance()) {
			System.out.println("Cannot withdraw more than your Balance : " + this.customer.getBalance() );
			return 0;
		}
	
			this.customer.subBalance(amount);
			System.out.println("Remaining Balance : " + this.customer.getBalance());
			return amount;			
	}
	
	@Override
	protected void transferAmount(float amount , Customer recipient, long acNumber) {
		if(amount < 0)
			throw new IllegalArgumentException("Transfer amount cannot be negative");
		
		if(acNumber == recipient.getAccountNumber()) {
			recipient.addBalance(amount);
			this.customer.subBalance(amount);
			
			// Checking account has 2 free transactions per month ; additional PKR10 per transactions 
			if(transactions.size() >= 2) {
				this.customer.subBalance(10);
				Transcation trans = new Transcation(recipient , getCurrentDatetime()  , amount , 10);
				this.transactions.addElement(trans);
				return;
			}
			
			Transcation trans = new Transcation(recipient , getCurrentDatetime()  , amount , 0);
			this.transactions.addElement(trans);
			

		}
	}
	
}


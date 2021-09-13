/**
 * @author Iftikhar Mehdi , 19I-0657
 * Advanced Programming Task 01 : Account Management System
 * Class : Checkings Account
 * Date: 12th Sept , 2021
 */


package Bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class CheckingsAccount extends BankAccount{
	
	private float Tax;
	private float totalTransactionFees;
	
	public CheckingsAccount() {
		this.Tax = 0;
		this.totalTransactionFees = 0;
	}
	
	public CheckingsAccount(Customer customer) {
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
		if(amount > this.customer.getBalance())
			System.out.println("Cannot withdraw more than your Balance : " + this.customer.getBalance() );
	
			this.customer.subBalance(amount);
			System.out.println("Remaining Balance : " + this.customer.getBalance());
			return amount;			
	}
	
	@Override
	protected void transferAmount(float amount , Customer recipient, long acNumber) {
		if(acNumber == recipient.getAccountNumber()) {
			recipient.addBalance(amount);
			this.customer.subBalance(amount);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			Transcation trans = new Transcation(recipient , dtf.format(now)  , amount);
			
			if(transactions.capacity() > 2)
				this.customer.subBalance(10);
			
			this.transactions.addElement(trans);
		}
	}
	
}


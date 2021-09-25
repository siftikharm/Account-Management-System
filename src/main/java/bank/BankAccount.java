/**
 * @author Iftikhar Mehdi , 19I-0657
 * Advanced Programming Task 01 : Account Management System
 * Date: 12th Sept , 2021
 */

package bank;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.util.*;

abstract public class BankAccount {
	
	protected Customer customer; 
	protected String dateCreated;
	protected Vector<Transcation> transactions;
	
	public BankAccount() {
		this.dateCreated = "";
		this.transactions = new Vector<Transcation>();
	}
	
	public BankAccount(Customer customer) {
		this.customer = customer;
		this.dateCreated = getCurrentDatetime();
		this.transactions = new Vector<Transcation>();
	}

	
	public String getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	protected void makeDeposit(float amount) {
		if(amount < 0 )
			throw new IllegalArgumentException("Transfer ammount cannot be negative");
		this.customer.addBalance(amount);
	}
	
	
	public String getCurrentDatetime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		return dtf.format(now);
	}
	
	protected void transferAmount(float amount , Customer recipient, long acNumber) {
		if(amount < 0 )
			throw new IllegalArgumentException("Transfer ammount cannot be negative");
		
		if(acNumber == recipient.getAccountNumber()) {
			recipient.addBalance(amount);
			this.customer.subBalance(amount); 
			Transcation trans = new Transcation(recipient , getCurrentDatetime()  , amount);
			this.transactions.addElement(trans);
		}
	}
		
	abstract protected float makeWithdrawl(float amount) ;
	
	
	protected void printStatement() {
		System.out.println("Customer Account Statement :\nName : " + this.customer.getName() +
				"\nAccount Number : " + this.customer.getAccountNumber() + 
				"\nAddress : " + this.customer.getAddress() + 
				"\nPhone Number : " + this.customer.getAddress() +
				"\nBalance : " + this.customer.checkBalance() 
				);
		
		 Iterator<Transcation> itr = transactions.iterator();  
		 
	        while(itr.hasNext()){  
	        	itr.next().printTransaction();
	        }
	        
	}
	
}






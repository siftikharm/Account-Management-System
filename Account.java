/**
 * @author Iftikhar Mehdi , 19I-0657
 * Advanced Programming Task 01 : Account Management System
 * Date: 12th Sept , 2021
 */

package Bank;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.util.*;

abstract class BankAccount {
	
	protected Customer customer; 
	protected String dateCreated;
	protected Vector<Transcation> transactions;
	
	public BankAccount() {
		this.dateCreated = "";
		this.transactions = new Vector<Transcation>();
	}
	
	public BankAccount(Customer customer , String dateCreated) {
		this.customer = customer;
		this.dateCreated = dateCreated;
		this.transactions = new Vector<Transcation>();
	}

	
	public String getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	protected void makeDeposit(float amount) {
		this.customer.addBalance(amount);
	}
	
	
	protected void transferAmount(float amount , Customer recipient, long acNumber) {
		if(acNumber == recipient.getAccountNumber()) {
			recipient.addBalance(amount);
			this.customer.subBalance(amount);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			Transcation trans = new Transcation(recipient , dtf.format(now)  , amount);

			this.transactions.addElement(trans);
		}
	}
		
	abstract protected float makeWithdrawl(float amount) ;
	
	
	protected void printStatement() {
		System.out.println("Customer Account Statement :\nName : " + this.customer.getName() +
				"Account Number : " + this.customer.getAccountNumber() + 
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






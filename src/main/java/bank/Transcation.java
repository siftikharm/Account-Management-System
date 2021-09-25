/**
 * @author Iftikhar Mehdi , 19I-0657
 * Advanced Programming Task 01 : Account Management System
 * Class : Transaction
 * Date: 12th Sept , 2021
 */


package bank;

public class Transcation {
	private Customer customer;
	private String transactionDateTime;
	private float transactionAmount;
	private float transactionFees;
	
	
	public Transcation() {
		this.transactionDateTime = "DateTime";
		this.transactionAmount = 0;
	}
	
	public Transcation(Customer customer, String transactionDate, float transactionAmount) {
		this.customer = customer;
		this.transactionDateTime = transactionDate;
		this.transactionAmount = transactionAmount;
	}
	
	public Transcation(Customer customer, String transactionDate, float transactionAmount , float transactionFees) {
		this.customer = customer;
		this.transactionDateTime = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionFees = transactionFees;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public String getTransactionDate() {
		return transactionDateTime;
	}
	
	public void setTransactionDate(String transactionDate) {
		this.transactionDateTime = transactionDate;
	}
	
	public float getTransactionAmount() {
		return transactionAmount;
	}
	
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	public void printTransaction() {
		System.out.println("Transaction : \nDate/Time : " + this.getTransactionDate() + 
				"\nAmount : " + this.getTransactionAmount() + "\nTransaction Fees : " + this.getTransactionFees());
	}

	public float getTransactionFees() {
		return transactionFees;
	}
}

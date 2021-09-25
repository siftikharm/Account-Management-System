/**
 * @author Iftikhar Mehdi , 19I-0657
 * Advanced Programming Task 01 : Account Management System
 * Date: 12th Sept , 2021
 */

package bank;
import java.util.Scanner;

public class Customer {
	
	private final long AccountNumber;
	private String Name;
	private String Address;
	private int PhoneNumber;
	private float balance;
	private boolean HasCAccount;
	private boolean HasSAccount;
	

	public Customer() {
		AccountNumber = 0;
		Name = "";
		Address = "";
		PhoneNumber = 0;
		balance = 0;
	}

	public Customer(long accountNumber ) {
		AccountNumber = accountNumber;
		Name = "";
		Address = "";
		PhoneNumber = 0;
		balance = 0;
	}
	
	public Customer(long accountNumber, String name, String address, int phoneNumber  ) {
		AccountNumber = accountNumber;
		Name = name;
		Address = address;
		PhoneNumber = phoneNumber;
		balance = 0;
	}
		
	public long getAccountNumber() {
		return this.AccountNumber;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}
	
	public float getBalance() {
		return this.balance;
	}
	
	public float checkBalance() {
		System.out.println("Customer Name : " + this.getName() );
		return this.balance;
	}

	protected void setBalance(float bal) {
		this.balance = bal;
	}
	protected void addBalance(float balance) {
		this.balance += balance;
	}
	
	protected void subBalance(float balance) {
		this.balance -= balance;
	}

	public String getAddress() {
		return this.Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public int getPhoneNumber() {
		return this.PhoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}
	
	public boolean isHasCAccount() {
		return HasCAccount;
	}


	public void setHasCAccount(boolean hasCAccount) {
		HasCAccount = hasCAccount;
	}


	public boolean isHasSAccount() {
		return HasSAccount;
	}


	public void setHasSAccount(boolean hasSAccount) {
		HasSAccount = hasSAccount;
	}

	public void setCustomerDetails() {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {
			try{
				System.out.println("Enter Name : ");
				String name = input.next();
				this.Name = name;
				flag = false;
				
				System.out.println("Address : ");
				String address = input.next();
				flag = false;
				this.Address = address;
				
				
				System.out.println("Enter Phone Number : ");
				int ph = input.nextInt();
				flag = false;
				this.PhoneNumber = ph;
			}
			catch(Exception E) {
				System.out.println(E);
				System.out.println("Enter again!");
				flag = true;
			}
						
		}
		
		input.close();
	}

	
}

/**
 * @author Iftikhar Mehdi , 19I-0657
 * Advanced Programming Task 01 : Account Management System
 * Class : main
 * Date: 12th Sept , 2021
 */

package bank;
import java.util.Scanner;
import java.util.*;

public class main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		byte choice ;
		
		Vector<SavingsAccount> SavingsVector = new Vector<SavingsAccount>();
		Vector<CheckingsAccount> CheckingsVector = new Vector<CheckingsAccount>();
		Vector<Customer> BankCustomers = new Vector<Customer>();
		
	while(true) {
		
		System.out.println("\t\t\t\tAccount Management System"
				+ "\n1. Open a new account\n" + 
				  "2. Login into a Account\n" + 
				  "3. Display Account Details\n" +
				  "4. Exit\n");
		
		 choice = input.nextByte();
		 if(choice == 4)
			 System.exit(0);
	
		switch(choice) {
		case 1 -> {
			System.out.println("Savings Account (1) or Checking Account (2) ?\n");
			byte option = input.nextByte();
			
				switch(option) {
				case 1 -> {
			
					System.out.println("Set your AccountNumber(immuatable) : ");
					long ac = input.nextLong();
					Customer customer = new Customer(ac);
					customer.setCustomerDetails();
					SavingsAccount account = new SavingsAccount(customer);
					customer.setHasSAccount(true);
					BankCustomers.addElement(customer);
					SavingsVector.addElement(account);
					System.out.println("Account Created!\n ");
					
				}
				
				case 2 -> {

					System.out.println("Set your AccountNumber(immuatable) : ");
					long ac = input.nextLong();
					Customer customer = new Customer(ac);
					customer.setCustomerDetails();
					CheckingsAccount account = new CheckingsAccount(customer);
					customer.setHasCAccount(true);
					BankCustomers.addElement(customer);
					CheckingsVector.addElement(account);
					System.out.println("Account Created!\n ");
					
					
				}
			
			}
		}
		
		case 2 -> {
			System.out.println("Savings (1) or Checkings Account (2) ? \n  ");
			byte option = input.nextByte();
			System.out.println("Enter your account number : ");
			long ac = input.nextLong();
			
			switch(option) {
			case 1 -> {
				
		        Iterator<SavingsAccount> itr = SavingsVector.iterator(); 
		        		        
		        while(itr.hasNext()){  
		            if(ac == itr.next().customer.getAccountNumber()) {
		            	System.out.println("Welcome!\n");
		            	itr.next().printStatement();
		            	
		    			System.out.println("\t\t\t\tOperations"
								+ "\n1. WithDraw\n" + 
								  "2. Deposit\n" + 
								  "3. Check Balance\n" +
								  "4. Transfer Amount\n" +
								  "5. Show Transcation History\n");
						
						byte operations = input.nextByte();
						
						switch(operations) {
						case 1 -> {
							System.out.println("Amount : ");
							float amount = input.nextFloat();
							itr.next().makeWithdrawl(amount);
						}
						
						case 2 -> {
							System.out.println("Amount : ");
							float amount = input.nextFloat();
							itr.next().makeDeposit(amount);
						}
						
						case 3 -> {
							itr.next().customer.checkBalance();
						}
						
						case 4 -> {
							System.out.println("Amount : ");
							float amount = input.nextFloat();
							
							System.out.println("Recipient Account Number : ");
							long number = input.nextLong();
							
						    Iterator<Customer> itrr = BankCustomers.iterator(); 
		        		        
						      while(itrr.hasNext()){  
						           if(number == itrr.next().getAccountNumber()) {
						        	   itr.next().transferAmount(amount, itrr.next(), number);
						        	   System.out.println("Transcation Successfull!\n");
						           }
						      }
						      
							
						}
						
						case 5 -> {
							itr.next().printStatement();
						}
						
						}
		            	break;
		            }
		            
		            if(!itr.hasNext()) {
		            	System.out.println("User not found\n");
		            }
		        } 
		        
			}
			
			case 2 -> {
				
	        Iterator<CheckingsAccount> itr = CheckingsVector.iterator();  
		        
		        while(itr.hasNext()){  
		            if(ac == itr.next().customer.getAccountNumber()) {
		            	System.out.println("Welcome!\n");
		            	itr.next().printStatement();
		            	
		    			System.out.println("\t\t\t\tOperations"
									+ "\n1. WithDraw\n" + 
									  "2. Deposit\n" + 
									  "3. Check Balance\n" +
									  "4. Transfer Amount\n" +
									  "5. Show Transcation History\n");
							
							byte operations = input.nextByte();
							
							switch(operations) {
							case 1 -> {
								System.out.println("Amount : ");
								float amount = input.nextFloat();
								itr.next().makeWithdrawl(amount);
							}
							
							case 2 -> {
								System.out.println("Amount : ");
								float amount = input.nextFloat();
								itr.next().makeDeposit(amount);
							}
							
							case 3 -> {
								itr.next().customer.checkBalance();
							}
							
							case 4 -> {
								System.out.println("Amount : ");
								float amount = input.nextFloat();
								
								System.out.println("Recipient Account Number : ");
								long number = input.nextLong();
								
							    Iterator<Customer> itrr = BankCustomers.iterator(); 
			        		        
							      while(itrr.hasNext()){  
							           if(number == itrr.next().getAccountNumber()) {
							        	   itr.next().transferAmount(amount, itrr.next(), number);
							        	   System.out.println("Transcation Successfull!\n");
							           }
							      }
							      
								
							}
							
							case 5 -> {
								itr.next().printStatement();
							}
							
							}
		            	break;
		            }
		            
		            if(!itr.hasNext()) {
		            	System.out.println("User not found\n");
		            }
		        } 
			}
			
			}
		}
		
		case 3 -> {
			System.out.println("Savings (1) or Checkings Account (2) ? \n  ");
			byte option = input.nextByte();
			System.out.println("Enter your account number : ");
			long ac = input.nextLong();
			
			switch(option) {
			case 1 -> {
				
		        Iterator<SavingsAccount> itr = SavingsVector.iterator();  
		        
		        while(itr.hasNext()){  
		            if(ac == itr.next().customer.getAccountNumber()) {
		            	System.out.println("Your Statement : \n");
		            	itr.next().printStatement();
		            	break;
		            }
		            
		            if(!itr.hasNext()) {
		            	System.out.println("User not found\n");
		            }
		        } 
		        
			}
			
			case 2 -> {
				
	        Iterator<CheckingsAccount> itr = CheckingsVector.iterator();  
		        
		        while(itr.hasNext()){  
		            if(ac == itr.next().customer.getAccountNumber()) {
		            	System.out.println("Your Statement : !\n");
		            	itr.next().printStatement();
		            	break;
		            }
		            
		            if(!itr.hasNext()) {
		            	System.out.println("User not found\n");
		            }
		        } 
			}
			
			}
		}
		
		}

	}

	}
}

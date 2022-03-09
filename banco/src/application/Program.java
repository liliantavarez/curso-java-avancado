package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		new BusinessAccount();
		
		Account acc = new Account(1001,"Alex,",1000.0);
		new BusinessAccount(1002,"Maria",0.0,500.0);
		
		acc.withdraw(200.0);
		
		System.out.println(acc.getBalance());
		
		//UPCASTING
		
	
		Account acc2 = new BusinessAccount(1003,"Bob",1000.0,100.0);
		Account acc3 = new SavingsAccount(1004,"Ana",1000.0,0.0);
		
		acc2.withdraw(200.00);
		System.out.println(acc2.getBalance());
		
		acc3.withdraw(200.00);
		System.out.println(acc3.getBalance());
		
		//DOWNCASTING
		BusinessAccount acc4 = (BusinessAccount)acc2;
		acc4.loan(100.00);
		
		
		//BusinessAccount acc5 = (BusinessAccount)acc3;
		
		if(acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0);
			System.out.println("Emprestimo!");
		}
		
		if(acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!");
			
		}

	}

}

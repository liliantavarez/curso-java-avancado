package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Programm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		List<Contribuinte> list = new ArrayList<>();
		
		System.out.print("Enter the number tax payers: ");
		int numberPayers = sc.nextInt();
		
		for (int index = 1; index <= numberPayers; index++) {
			System.out.println("Tax payer "+index+"# data: ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIcome = sc.nextDouble();

			if(ch == 'i' || ch == 'I') {
				System.out.print("Health expenditures: ");
				double hExpenditures = sc.nextDouble();
				list.add(new PessoaFisica(name, anualIcome, hExpenditures));
			}else{
				System.out.print("Number of employees: ");
				int numEmp = sc.nextInt();
				list.add(new PessoaJuridica(name,anualIcome,numEmp));
			}
			
		}
		
		double totalTaxe = 0.0;
		System.out.println();
		System.out.println("TAXES PAID: ");
		
		for (Contribuinte contribuinte : list) {
			totalTaxe += contribuinte.calcImposto();
			System.out.println(contribuinte.getNome()+": $"+contribuinte.calcImposto());
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $"+totalTaxe);

		sc.close();
	}

}

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method 
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("(dd/MM/yyyy)");
		
		System.out.println("Enter contract data");
		System.out.println("Number: ");
		int number = sc.nextInt();
		System.out.println("Date (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.next());
		System.out.println("Contract value: ");
		double value = sc.nextDouble();
		System.out.println("Enter number of installments: ");
		int numberInstallments = sc.nextInt();
		
		System.out.println();
		System.out.println("Installments: ");
		
		
		sc.close();
	}

}

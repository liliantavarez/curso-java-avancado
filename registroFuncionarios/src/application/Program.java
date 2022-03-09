package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourceEmployess;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		List<Employee> listEmployees = new ArrayList<>();
		
		System.out.println("Quantidade de funcionarios: ");
		int qntFun = sc.nextInt();
		
		for(int index = 1; index <= qntFun; index++) {
			System.out.print("Insira os dados do funcionario ["+index+"] : ");
			System.out.print("Terceirisado(s/n)?");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Horas: ");
			int horas = sc.nextInt();
			System.out.print("Valor por hora: ");
			double vHora = sc.nextDouble();
			
			if(ch == 's' || ch == 'S') {
			System.out.print("Dispesas adicionais: ");
			double adicional = sc.nextDouble();
			listEmployees.add(new OutsourceEmployess(nome, horas, vHora, adicional));
			}else {
				listEmployees.add(new Employee(nome, horas, vHora));
			}
		}
			
			System.out.println();
			System.out.println("PAYMENTS: ");
			for (Employee employee : listEmployees) {
				System.out.println(employee.getName() +"- $"+ String.format("%.2f", employee.payment()));
			}
		
		
		sc.close();
	}

}

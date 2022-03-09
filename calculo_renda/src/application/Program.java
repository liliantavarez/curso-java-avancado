package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Nome do departamento:");
		String departamento = sc.nextLine();
		System.out.println("Entre com os dados do Trabalhador");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nivel: ");
		String nivel = sc.nextLine();
		System.out.print("Salario Base:");
		double salarioBase = sc.nextDouble();
		Worker worker = new Worker(nome,WorkerLevel.valueOf(nivel),salarioBase,new Department(departamento));
		
		System.out.println("Quantidade de contratos do funcionario "+nome+":");
		int contratos = sc.nextInt();
		
		for(int index = 1; index <= contratos; index++) {
			System.out.println("Insira as informaçoes do contrato "+index);
			System.out.print("Data(DD/MM/AAAA): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Duracao (horas): ");
			int duracao = sc.nextInt();
			HourContract contract = new HourContract(dataContrato, valorHora, duracao);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Informe o mes e ano para calcular salario (MM/AAAA): aa");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0,2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome: "+worker.getName());
		System.out.println("Departamento: "+worker.getDepartment().getName());
		System.out.println("Salario de "+mesAno+": "+String.format("%.2f",worker.inCome(ano, mes)));
		

		sc.close();
	}

}

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Insira os dados do cliente");
		System.out.print("Nome:");
		String name = sc.nextLine();
		System.out.print("E-mail:");
		String email = sc.next();
		System.out.print("Data de Aniversario (DD/MM/AAAA):");
		Date date = sdf.parse(sc.next());
		
		Client newClient = new Client(name,email,date);
		
		System.out.println("Insira os dados do pedido");
		System.out.print("Status:");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		System.out.print("Quantidade de itens:");
		int itens = sc.nextInt();
		sc.nextLine();
				
		Order newOrder = new Order(new Date(),status,newClient);		
		
		for(int index = 1; index <= itens; index++ ) {
			System.out.println("Insita os dados do item ["+index+"]");
			System.out.print("Nome: ");
			String nameProduct = sc.nextLine();
			System.out.print("Preco: ");			
			double price = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			OrderItem newOrderItem = new OrderItem(quantity,price,new Product(nameProduct,price));
			newOrder.addItem(newOrderItem);
		}
		
		System.out.println();
		System.out.println(newOrder);
		sc.close();
	}
	

}

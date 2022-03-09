package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> produtos = new ArrayList<>();
		
		System.out.print("Quantidade de produtos:");
		int qntProdutos = sc.nextInt();
		
		for(int index = 1; index <=qntProdutos;index++) {
			System.out.println("Insira os dados do produto ["+index+"]");
			System.out.print("Comum, usadao ou importado (c/u/i)? ");
			char tipoProduto = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			if(tipoProduto == 'I' || tipoProduto == 'i') {
				System.out.print("Valor do imposto: ");
				double imposto = sc.nextDouble();
				produtos.add(new ImportedProduct(nome, preco, imposto));	
			}else if(tipoProduto == 'u' || tipoProduto == 'U') {
				System.out.print("Data de fabricação (DD/MM/AAAA): ");
				Date dataFabricacao = sdf.parse(sc.next());
				System.out.println(dataFabricacao);
				produtos.add(new UsedProduct(nome, preco, dataFabricacao));
			}else {
				produtos.add(new Product(nome, preco));
			}
			
		}

		System.out.println();
		for (Product product : produtos) {
			System.out.println(product.priceTag());
		}
		
		
		sc.close();
	}
	
}

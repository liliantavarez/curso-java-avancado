package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Produto;

public class Program {
	public static void main(String[] args) {

		List<Produto> produtos = new ArrayList<>();
		String[] produto = new String[2];
		String file = "D:\\Documents\\ws-eclipse\\desafioArquivo\\produtos.csv";
		File past = new File("D:\\Documents\\ws-eclipse\\desafioArquivo");
		new File(past + "\\out").mkdir();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while (line != null) {
				produto = line.split(",");

				String nome = produto[0];
				Double preco = Double.parseDouble(produto[1]);
				int quantidade = Integer.parseInt(produto[2]);
				produtos.add(new Produto(nome, preco, quantidade));
				line = br.readLine();
			}

			String novoArquivo = past + "\\out\\summary.csv";

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(novoArquivo, true))) {
				for (Produto product : produtos) {
					bw.write(product.getNome() + ", " + product.valorTotal());
					bw.newLine();
				}
			
			} catch (IOException e) {
				System.out.println("Error: "+e.getStackTrace());
			}

		} catch (IOException e) {
			System.out.println("Error: "+e.getStackTrace());
		}

	}

}

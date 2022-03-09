package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String pathReader = "C:\\temp\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(pathReader))) {
			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		String[] lines = new String[] {"Bom dia","Boa tarde","Boa noite"};
		String pathWriter = "C:\\temp\\out.pdf";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathWriter, true))){
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}catch(IOException e){
			e.printStackTrace(); //Tramaneto de erro
		}

	}

}

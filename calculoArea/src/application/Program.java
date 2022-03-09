package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		List<Shape> listaShapes = new ArrayList<>();
		
		System.out.print("Quantidade de formas: ");
		int qntFormas = sc.nextInt();
		
		for(int index=1;index<=qntFormas;index++) {
			System.out.println("Informaçoes da forma ["+index+"]");
			System.out.print("Retangalo ou Circulo (r/c)? ");
			char forma = sc.next().charAt(0);
			System.out.print("Cor (PRETO/AZUL/VERMELHO)? ");
			Color cor = Color.valueOf(sc.next());
			if (forma == 'r' || forma =='R') {
				System.out.print("Width: ");
				double width = sc.nextDouble();
				System.out.print("Height: ");
				double height = sc.nextDouble();
				listaShapes.add(new Rectangle(cor, width, height));
			}else {
				System.out.print("Radius: ");
				double radius = sc.nextDouble();
				listaShapes.add(new Circle(cor, radius));
			}
		}
		
		System.out.println();
		System.out.println("SHAPE AREAS: ");
		for (Shape shape : listaShapes) {
			System.out.println(String.format("%.2f",shape.area()));
		}	

		sc.close();
	}

}

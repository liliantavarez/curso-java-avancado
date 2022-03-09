package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxServices;
import model.services.RentalService;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (DD/MM/YYYY hh:ss): ");
		Date pickup = sdf.parse(sc.nextLine());
		System.out.print("Return (DD/MM/YYYY hh:ss): ");
		Date returnDate = sdf.parse(sc.nextLine());

		CarRental carReantal = new CarRental(pickup, returnDate, new Vehicle(carModel));

		System.out.print("Enter price per hour: ");
		Double priceHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		Double priceDay = sc.nextDouble();

		RentalService rentalService = new RentalService(priceDay, priceHour, new BrazilTaxServices());
		rentalService.processInvoice(carReantal);

		System.out.println();
		System.out.println("INVOICE: ");
		System.out.println("Basic paymen: " + String.format("%.2f", carReantal.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", carReantal.getInvoice().getTax()));
		System.out.println("Total paymen: " + String.format("%.2f", carReantal.getInvoice().getTotalPayment()));

		sc.close();
	}
}

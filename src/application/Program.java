package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.PaymentService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Enter contract data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Date (dd/MM/yyyy): ");
			String date = sc.nextLine();
			System.out.print("Contract value: ");

			double totalValue = sc.nextDouble();
			System.out.print("Enter number of installments: ");
			int numParcel = sc.nextInt();
			Contract c1 = new Contract(number, sdf.parse(date), totalValue);
			PaymentService PS = new PaymentService(c1, numParcel);
			PS.Payment(PS);

		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}

}

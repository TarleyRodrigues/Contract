package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installments;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Enter contract data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Date (dd/MM/yyyy): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Contract value: ");

			double totalValue = sc.nextDouble();
			System.out.print("Enter number of installments: ");
			int numMonths = sc.nextInt();
			Contract contract = new Contract(number, date, totalValue);

			ContractService cs = new ContractService(new PaypalService());
			cs.processContract(contract, numMonths);

			System.out.println("Installments: \n-----------------------------------");

			for (Installments inst : contract.getInstallments()) {
				System.out.println(inst);
			}
		} catch (InputMismatchException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}

}

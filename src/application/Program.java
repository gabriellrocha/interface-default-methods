package application;

import java.util.Scanner;

import services.BrazilInterestService;
import services.InterestService;

public class Program {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		double amountDouble;
		
		System.out.print("Amount: ");
		String amount = input.next();
		if (amount.contains(",")) {
			amountDouble = Double.parseDouble(amount.replace(",", "."));
		} else {
			amountDouble = Double.parseDouble(amount);
		}
		System.out.print("Months: ");
		int months = input.nextInt();
		
		InterestService in = new BrazilInterestService();
		try {
			double payment = in.payment(amountDouble, months);			
			System.out.print("Payment after " + months + " months: ");
			System.out.println(String.format("%.2f", payment));
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		input.close();
	}

}

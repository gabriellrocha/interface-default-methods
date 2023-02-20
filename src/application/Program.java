package application;

import java.util.Scanner;

import services.BrazilInterestService;
import services.InterestService;

public class Program {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Amount: ");
		String amount = input.next();
		
		System.out.print("Months: ");
		int months = input.nextInt();
		
		InterestService in = new BrazilInterestService();
		
		try {
			double amountDouble = replaceComma(amount);
			double payment = in.payment(amountDouble, months);			
			System.out.print("Payment after " + months + " months: ");
			System.out.println(String.format("%.2f", payment));
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		input.close();
	}
	
	public static double replaceComma(String amount) { 
		if (amount.contains(",")) {
			return Double.parseDouble(amount.replace(",", "."));
		} 
		return Double.parseDouble(amount);
		
	}
}

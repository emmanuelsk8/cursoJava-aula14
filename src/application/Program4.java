package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Payer;
import entities.PayerCompany;
import entities.PayerIndividual;

public class Program4 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Payer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Tax payer #"+ i + " data:");
			System.out.print("Individual or Company (i/c) ? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Anual Income: ");
			double anualIncome = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Health Expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new PayerIndividual(name, anualIncome, healthExpenditures));
			}else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new PayerCompany(name, anualIncome, numberOfEmployees));
			}
		}
		System.out.println();
		System.out.println("TAXES PAID:");
		double sum = 0;
		for(Payer payer : list) {
			System.out.println(payer.getName() + ": $ " + String.format("%.2f", payer.taxesPaid()));
			sum += payer.taxesPaid();
		}
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f", sum);
		
		sc.close();
	}

}

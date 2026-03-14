package A.basics;

import java.util.Scanner;

public class IfElseStatements {

	public static void getVoterDetails() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Enter your name:");
		String name = sc.nextLine();
		
		System.out.println("Are you an Indian Citizen?(yes/no)");
		String citizen = sc.nextLine();
		String message = citizen.equals("yes")?"Please proceed!":"You cannot proceed further";
		System.out.println(message);
		
		if(citizen.equals("no")) {
			return;
		}
		
		
		System.out.println("Hi, "+name+". Please enter your age:");
		int age = sc.nextInt();	
		sc.nextLine();
		if(age>=18) {
			System.out.println("You are eligible to vote");
		}else {
			System.out.println("Sorry, you are not eligible to vote, please come back after "+ (18-age)+ " years!");
			return;
		}
		
		System.out.println("State your proof of Identity?(VoterID/Passport/Adhaar Card)");
		String ans = sc.nextLine();
		if(ans.equals("VoterID")) {
			System.out.println("Please bring your "+ans);
		}else if(ans.equals("Passport")) {
			System.out.println("Please bring your "+ans);
		}else if(ans.equals("Adhaar Card")) {
			System.out.println("Please bring your "+ans);
		}else {
			System.out.println("Invalid proof of Identity!");
			return;
		}
		
		System.out.println("Happy Voting! Choose wisely!");
		
	}
	
	public static void main(String[] args) {
		
	
		getVoterDetails();
		
	}
}

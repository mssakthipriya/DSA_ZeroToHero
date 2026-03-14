package A.basics;

import java.util.Scanner;

public class InputOutput{
	
	
	public static void printWelcomeNote() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("May I know who you are?");
		String name = sc.nextLine();
		
		System.out.println("Welcome "+name+" to DSA Course. Hope you achieve all your dreams! Good Luck!!");
		
	}
	
	public static void main(String args[]){
		printWelcomeNote();
		
	}
}
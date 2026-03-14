package D.basicmaths;

import java.util.ArrayList;

public class AllDivisors {
	
	public static ArrayList<Integer> getAllDivisorsOpt(int num){
		ArrayList<Integer> divList = new ArrayList<>();
		
		
		return divList;
	}
	
	public static void getAllDivisors(int num) {
		for(int i=1;i<=num/2;i++) {
			if(num%i==0) {
				System.out.println(i);
			}
		}
		System.out.println(num);
	}
	
	public static void main(String[] args) {
		getAllDivisors(12);
	}

}

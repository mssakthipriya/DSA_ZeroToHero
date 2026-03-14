package F.Hashing;

import java.util.Scanner;

public class BasicHashing {
	
	public static int[] hashFunction(int[] arr,int range) {
		int[] hashArr = new int[range+1];
	
		return hashArr;
	}
	
	
	public static void main(String[] args) {
		int range = 20;
		int[] arr = {1,2,5,4,5,6,3,15,3,6,5,3,6,5,6,17,3,6,13,15,20};
		
		int[] hashArr = hashFunction(arr, range);
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number");
		int x = s.nextInt();
		System.out.println("The count of :");
		
		System.out.println(hashArr[x]);
		
	}

}

package B.patterns;

/*
----------
Pattern B
* 
* *
* * *
* * * *
* * * * *
----------

*/

public class PatternB {
	
	public static void getPettern(int n) {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		getPettern(5);
	}
	

}

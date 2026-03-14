package B.patterns;

/*
----------
Pattern E
* * * * * 
* * * *
* * *
* *
*
----------

*/

public class PatternE {
	
	public static void getPettern(int n) {
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=(n-i);j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		getPettern(5);
	}
}

package B.patterns;

/*
----------
Pattern G
        *
      * * *
    * * * * *
  * * * * * * *
* * * * * * * * *
----------

*/

public class PatternG {
	
	public static void getPettern(int n) {
		
		for(int i=0;i<n;i++) {
			for(int k=n-1;k>i;k--) {
				System.out.print("  ");
			}
				
			for(int j=0;j<((2*i)+1);j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		getPettern(5);
	}
}

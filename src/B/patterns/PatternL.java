package B.patterns;

/*
----------
Pattern L
1             1
1 2         2 1
1 2 3     3 2 1
1 2 3 4 4 3 2 1
----------

*/

public class PatternL {
	
	public static void getPettern(int n) {
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+" ");
			}
			
			for(int j=1;j<(2*(n-i)+1);j++) {
				System.out.print("  ");
			}
			
			for(int j=i;j>=1;j--) {
				System.out.print(j+" ");
			}
			
			System.out.println();
		}
		

	}
	public static void main(String[] args) {
		getPettern(4);
	}
}

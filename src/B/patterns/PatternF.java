package B.patterns;

/*
----------
Pattern F
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1
----------

*/

public class PatternF {
	
	public static void getPettern(int n) {
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<=(n-i);j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		getPettern(5);
	}
}

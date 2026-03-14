package B.patterns;

/*
----------
Pattern V
4444444
4333334
4322234
4321234
4322234
4333334
4444444
----------

*/

public class PatternV {
	
	public static void getPettern(int n) {
		
		for(int i=0;i<(2*n-1);i++) {
			for(int j=0;j<(2*n-1);j++) {
				int top = i;
				int left = j;
				int right = (2*n-2)-i;
				int bottom = (2*n-2)-j; 
				
				int num = Math.min(Math.min(right, left),Math.min(top, bottom));
				
				System.out.print(n- num+" ");
			}

			System.out.println();
		}
		

	}
	public static void main(String[] args) {
		getPettern(5);
	}
}

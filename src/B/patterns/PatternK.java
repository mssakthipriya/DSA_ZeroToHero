package B.patterns;

/*
----------
Pattern K
1
0 1
1 0 1
0 1 0 1
1 0 1 0 1
----------

*/

public class PatternK {
	
	public static void getPettern(int n) {
		
		int count =1;
		
		for(int i=0;i<n;i++) {
			int cnt = count;
			for(int j=0;j<=i;j++) {				
				System.out.print(cnt+" ");
				if(cnt==1) {
					cnt--;
				}else {
					cnt++;
				}
			}
			System.out.println();
			if(count==1) {
				count--;
			}else {
				count++;
			}
		}
		

	}
	public static void main(String[] args) {
		getPettern(5);
	}
}

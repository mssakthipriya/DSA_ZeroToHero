package D.basicmaths;

public class CountDigits {
	//Complexity: O(log10N + 1)	
	public static int getCount(int num) {
		int count=0;
		while(num!=0) {
			num=num/10;
			count++;
		}
		
		
		return count;
	}
	
	//Complexity: O(1)
	public static int getCountOpt(int num) {
		
		int count  = (int) (Math.log10(num)+1);
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(getCount(778934));
		System.out.println(getCountOpt(778934));
		
	}

}

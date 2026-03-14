package L.RecursionPattern;

public class JosephusProblem {

	public static int getJosephusPosition(int n, int k) {
		if(n==1) {
			return 0;
		}
		
		return (getJosephusPosition(n-1, k)+k)%n;
	}
	public static void main(String[] args) {
		int n=7;
		int k=3;
		int position = getJosephusPosition(n,k);
		System.out.println("Joseph should be paced in position:"+position+" to survive");
	}
}

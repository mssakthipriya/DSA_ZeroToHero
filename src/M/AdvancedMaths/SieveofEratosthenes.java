package M.AdvancedMaths;
//T.C: O(N)+O(Nlog(logN))+O(N)
public class SieveofEratosthenes {
	
	public static void printAllPrime(int n) {
		int[] prime = new int[n+1];
		for(int i=2;i<=n;i++) {
			prime[i]=1;
		}
		
		for(int i=2;i*i<n;i++) {
			for(int j=i*i;j<=n;j=j+i) {
				prime[j]=0;
			}
		}
		
		for(int i=0;i<=n;i++) {
			if(prime[i]==1)
				System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		int n = 30;
		
		printAllPrime(30);
	}

}

package M.AdvancedMaths;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
static int n = 100000;
static int[] SPF = new int[n+1];
	public static void createSPF() {
		for(int i=1;i<=n;i++) {
			SPF[i]=i;
		}
		for(int i=2;i*i<n;i++) {
			if(SPF[i]==i) {
				for(int j=i*i;j<=n;j=j+i) {
					if(SPF[j]==j) {
						SPF[j]=i;
					}
				}
			}
		}
	}
	public static List<List<Integer>> getPrimeFactors(int[] queries){
		List<List<Integer>> ans = new ArrayList<>();
		for(int i=0;i<queries.length;i++) {
			List<Integer> list=new ArrayList<>();
			int n = queries[i];
			while(n!=1) {
				list.add(SPF[n]);
				n = n/SPF[n];
			}
			ans.add(list);
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int[] queries = {2, 3, 4, 5, 6};
		createSPF();
		List<List<Integer>> ans = getPrimeFactors(queries);
		System.out.println(ans.toString());
	}
}

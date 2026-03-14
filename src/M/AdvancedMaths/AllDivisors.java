package M.AdvancedMaths;

import java.util.ArrayList;
import java.util.List;

public class AllDivisors {
	public static List<Integer> getAllDivisors(int n){
		List<Integer> ans = new ArrayList<>();
		
		for(int i=1;i*i<n;i++) {
			if(n%i==0) {
				ans.add(i);
			}
			if(n/i!=i) {
				ans.add(n/i);
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int n = 36;
		
		List<Integer> ans = getAllDivisors(36);
		
		System.out.println(ans.toString());
	}

}

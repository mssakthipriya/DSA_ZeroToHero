package L.RecursionPattern.Combos;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	public static void evaluate(String nums, int target, int index, long prev, long res,String expr,List<String> ans) {
		if(index==nums.length()) {
			if(res==target) {
				ans.add(expr);
			}
			return;
		}
		
		for(int i=index;i<nums.length();i++) {
			
			if(i>index && nums.charAt(index)=='0') return;
			
			String curr = nums.substring(index, i+1);
			long curr_val = Long.parseLong(curr);

			if(index==0) {
				evaluate(nums, target, i+1, curr_val, curr_val, curr, ans);
			}else {
				evaluate(nums, target, i+1, curr_val, res+curr_val, expr+"+"+curr, ans);
				evaluate(nums, target, i+1, -curr_val, res-curr_val, expr+"-"+curr, ans);
				evaluate(nums, target, i+1, prev*curr_val, res-prev+prev*curr_val, expr+"*"+curr, ans);
			}
		}
		
	}
	public static List<String> getExpressions(String nums, int target){
		List<String> ans = new ArrayList<String>();
		
		evaluate(nums,target,0,0,0,"",ans);
		
		return ans;
	}
	
	public static void main(String[] args) {
		String nums = "232";
		int target = 8;

		List<String> ans = getExpressions(nums,target);
		
		for(String s: ans) {
			System.out.println(s);
		}
		
	}

}

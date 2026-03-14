package N.StackAndQueue.MonotonicStack.ImplementationProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
    	int n = nums.length;       
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int cnt = 0;
        for(int i=0;i<n;i++) {
        	if(!dq.isEmpty() &&(dq.peekFirst()<=i-k)) {
        		dq.pollFirst();
        		ans[dq.peekFirst()] = nums[dq.peekFirst()];
        	}
        	while(!dq.isEmpty() && (nums[dq.peekLast()]<nums[i])) {
        		dq.pollLast();
        	}
        	
        	dq.offerLast(i);
			if (i >= k - 1) {
				ans[cnt++] = nums[dq.peek()];
			}
        }
        
        return ans;
    }
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		
		int[] ans = maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(ans));
	}
}

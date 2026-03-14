package N.StackAndQueue.MonotonicStack;

import java.util.Stack;

public class SubArrayRanges {
	public static int[] nse(int[] arr) {
		int n = arr.length;
		int[] nseArr = new int[n];
		Stack<Integer> st = new Stack<>();
		
		for(int i=n-1;i>=0;i--) {
			while(!st.isEmpty() && arr[st.peek()]>=arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				nseArr[i] = n;
			}else {
				nseArr[i] = st.peek();
			}
			st.push(i);
		}
		
		return nseArr;
	}
	public static int[] psee(int[] arr) {
		int n = arr.length;
		int[] nseArr = new int[n];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<n;i++) {
			while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				nseArr[i] = -1;
			}else {
				nseArr[i] = st.peek();
			}
			st.push(i);
		}
		
		return nseArr;
	}
	public static int[] nge(int[] arr) {
		int n = arr.length;
		int[] nseArr = new int[n];
		Stack<Integer> st = new Stack<>();
		
		for(int i=n-1;i>=0;i--) {
			while(!st.isEmpty() && arr[st.peek()]<=arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				nseArr[i] = n;
			}else {
				nseArr[i] = st.peek();
			}
			st.push(i);
		}
		
		return nseArr;
	}
	public static int[] pgee(int[] arr) {
		int n = arr.length;
		int[] nseArr = new int[n];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<n;i++) {
			while(!st.isEmpty() && arr[st.peek()]<arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				nseArr[i] = -1;
			}else {
				nseArr[i] = st.peek();
			}
			st.push(i);
		}
		
		return nseArr;
	}
    public static long subArrayRanges(int[] nums) {
        long ranges = 0;
        int n = nums.length;
        int[] nsi = nse(nums);
        int[] psei = psee(nums);
        int[] ngi = nge(nums);
        int[] pgei = pgee(nums);
        int greatest = 0;
        int smallest = 0;
        for(int i=0;i<n;i++) {
        	int maxLeft = i-pgei[i];
        	int maxRight = ngi[i]-i;        	
        	long maxFreq = maxLeft*maxRight;
        	greatest+=maxFreq*nums[i];
        			
        	int minLeft = i-psei[i];
        	int minRight = nsi[i]-i;        	
        	long minFreq = minLeft*minRight;
        	smallest+=minFreq*nums[i];
        	
        }
        
        ranges = greatest - smallest;
        return ranges;    	
    }
	public static void main(String[] args) {
		int[] nums = {4,-2,-3,4,1};

		long ranges = subArrayRanges(nums);
		System.out.println(ranges);
	}

}

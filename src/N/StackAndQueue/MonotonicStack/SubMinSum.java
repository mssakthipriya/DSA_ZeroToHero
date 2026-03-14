package N.StackAndQueue.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class SubMinSum {
	public static int[] NSE(int[] arr) {
		int n = arr.length;
		int[] nseArr = new int[n];
		Stack<Integer> st = new Stack<>();
		for(int i = n-1;i>=0;i--) {
			while(!st.isEmpty() && arr[st.peek()] >=arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				nseArr[i]=n;
			}else {
				nseArr[i] = st.peek();
			}
			st.push(i);
		}
		
		return nseArr;
	}
	public static int[] PSEE(int[] arr) {
		int n = arr.length;
		int[] pseArr = new int[n];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<n;i++) {
			while(!st.isEmpty() && arr[st.peek()] >arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				pseArr[i]=-1;
			}else {
				pseArr[i] = st.peek();
			}
			st.push(i);
		}
		

		return pseArr;
	}
    public static int sumSubarrayMins(int[] arr) {
    	int n = arr.length;
       int sum = 0;
       int[] nse = NSE(arr);
       System.out.println(Arrays.toString(nse));
       int[] psee = PSEE(arr);
       System.out.println(Arrays.toString(psee));
       int mod = (int)1e9+7;
       
       for(int i=0;i<n;i++) {
    	   int left = i-psee[i];
    	   int right = nse[i]-i;
    	   
    	   long freq = right*left;
    	   int val = (int)(freq*arr[i])%mod;
    	   sum = (sum+val)%mod;
    	   
       }
       
       return sum;
    }
	public static void main(String[] args) {
		//int[] arr = {3,1,2,4};
		int[] arr = {11,81,94,43,3};
		
		int sum = sumSubarrayMins(arr);
		
		System.out.println("sum: "+sum);
	}

}

package N.StackAndQueue.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
    	int n = asteroids.length;
    	Stack<Integer> st = new Stack<>();
    	for(int i=0;i<n;i++) {
    		if(asteroids[i]>0) {
    			st.push(asteroids[i]);
    		}else {
    			while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(asteroids[i])) {
    				st.pop();
    			}
    			
    			if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i])) {
    				st.pop();
    			}else if(st.isEmpty() || st.peek()<0) {
    				st.push(asteroids[i]);
    			}
    		}
    	}
    	if(st.isEmpty()) return new int[] {};
    	
    	int[] ans = new int[st.size()];
    	int i = st.size()-1;
    	while(!st.isEmpty()) {
    		ans[i] = st.pop();
    		i--;
    	}
    	
    	return ans;
    }
	public static void main(String[] args) {
		int[] asteroids = {3,5,-6,2,-1,4};
		
		int[] ans = asteroidCollision(asteroids);
		
		System.out.println(Arrays.toString(ans));
	}

}

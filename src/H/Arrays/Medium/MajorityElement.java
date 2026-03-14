package H.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	//Boyer Moore Majority Vote Algorithm
	//The intuition behind is basically pigeon hole principle, as you'll always have count>=1 (for the majority element) after cancelling with all other elements.
	public static int majorityElementMoores(int[] nums) {
		int n = nums.length;
		int count = 0;
		int majElm = 0;
		for(int i=0;i<n;i++) {
			if(count==0) {
				count = 1;
				majElm = nums[i];
			}else if(nums[i]==majElm){
				count++;
			}else {
				count--;
			}
		}
		int times = 0;
		for(int j=0;j<n;j++) {
			if(nums[j]==majElm) {
				times++;
			}
		}
		if(times>n/2)
			return majElm;
		
		return -1;
	}
	
	
	public static int majorityElement(int[] nums) {
		int n=nums.length;
		Map<Integer,Integer> count = new HashMap<>();
		for(int i=0;i<n;i++) {
			if(count.containsKey(nums[i])) {
				count.put(nums[i], count.get(nums[i])+1);
			}else {
				count.put(nums[i], 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> e: count.entrySet()) {
			if(e.getValue()>n/2)
				return e.getKey();
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] arr= {4,4,2,4,3,4,4,3,2,4};
		System.out.println("The majority element in this array is:"+ majorityElement(arr));
		System.out.println("(Moore Majority Vote Algorithm)The majority element in this array is:"+ majorityElementMoores(arr));
		
	}
}

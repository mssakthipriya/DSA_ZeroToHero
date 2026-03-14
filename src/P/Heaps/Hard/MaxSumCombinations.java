package P.Heaps.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MaxSumCombinations {
	public static List<Integer> getMaxSumCombos(int[] nums1, int[] nums2, int k){
		int n = nums1.length;
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		reverse(nums1);
		reverse(nums2);

		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y)->y[0]-x[0]);
		Set<String> vis = new HashSet<>();
		
		maxHeap.add(new int[] {nums1[0]+nums2[0],0,0});
		vis.add("0#0");
		
		while(result.size()<k && !maxHeap.isEmpty()) {
			int[] top = maxHeap.poll();
			int sum = top[0];
			int i = top[1];
			int j = top[2];
			result.add(sum);
			
			if(i+1<n && !vis.contains((i+1)+"#"+j)) {
				maxHeap.offer(new int[] {nums1[i+1]+nums2[j],i+1,j});
				vis.add((i+1)+"#"+j);
			}
			
			if(j+1<n && !vis.contains(i+"#"+(j+1))) {
				maxHeap.offer(new int[] {nums1[i]+nums2[j+1],i,j+1});
				vis.add(i+"#"+(j+1));
			}
			
		}

		
		return result;
	}
	public static void reverse(int[] nums) {
		int i=0;
		int j = nums.length-1;
		
		while(i<j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
	public static void main(String[] args) {
		int[] nums1 = {3, 4, 5};
		int[] nums2 = {2, 6, 3};
		int k = 2;
		
		List<Integer> result = getMaxSumCombos(nums1,nums2,k);
		
		System.out.println(result.toString());
		
	}

}

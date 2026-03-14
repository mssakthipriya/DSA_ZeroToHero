package H.Arrays.Hard;

public class MaxProdSub {

	public static int getMaxProduct(int[] nums) {
		int max = nums[0];
		int prodL = 1;
		int prodR = 1;
		for(int i=0;i<nums.length;i++) {
			if(prodL==0) prodL=1;
			if(prodR==0) prodR=1;
			prodL = prodL*nums[i];
			prodR = prodR*nums[nums.length-1-i];
			max = Math.max(max, Math.max(prodL, prodR));
		}
		
		return max;
	}
	public static void main(String[] args) {
		
		//int[] arr = {2,3,-2,-5,6,-1,4};
		int[] arr = {-2,0,-1};
		int prod = getMaxProduct(arr);
		System.out.println("the maximum product of the sub array is:"+prod);
	}
}

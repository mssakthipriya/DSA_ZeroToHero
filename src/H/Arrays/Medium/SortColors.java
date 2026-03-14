package H.Arrays.Medium;

import java.util.Arrays;

public class SortColors {
	//Dutch National flag algorithm
	/***
	 The idea is to sort the array of size n using three pointers:
	 lo = 0, mid = 0 and hi = n - 1 such that the array is divided into three parts -

    arr[0] to arr[lo - 1]: This part will have all the zeros.
    arr[lo] to arr[mid - 1]: This part will have all the ones.
    arr[hi + 1] to arr[n - 1]: This part will have all the twos.

	Here, lo indicates the position where next 0 should be placed,
	mid is used to traverse through the array and
	hi indicates the position where next 2 should be placed.
	 ***/
    public static void sortColorsDutch(int[] nums) {
    	int low =0;
    	int mid = 0;
    	int high = nums.length-1;
    	
    	while(mid<=high){
    		if(nums[mid]==0) {
    			int temp = nums[mid];
    			nums[mid] = nums[low];
    			nums[low] = temp;
    			low++;
    			mid++;
    		}else if(nums[mid]==1) {
    			mid++;
    		}else {
    			int temp = nums[mid];
    			nums[mid] = nums[high];
    			nums[high] = temp;
    			high--;
    			}
    	}
    	
    }
	
    public static void sortColors(int[] nums) {
    	int j=0;
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]==0) {
        		int temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        		j++;
        			
        	}
        }
        
        for(int i=j;i<nums.length;i++) {
        	if(nums[i]==1) {
        		int temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        		j++;
        			
        	}
        }
    }
	
	public static void main(String[] args) {
		int[] arr = {2,0,2,1,1,0};
		sortColors(arr);
		System.out.println(Arrays.toString(arr));
		
		int[] arr2 = {2,0,2,1,1,0};
		sortColorsDutch(arr2);
		System.out.println(Arrays.toString(arr2));
		
	}

}

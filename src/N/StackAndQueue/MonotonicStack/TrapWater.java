package N.StackAndQueue.MonotonicStack;

public class TrapWater {
	
	public static int trap(int[] height) {
		int result = 0;
		int n = height.length;
		int l = 0;
		int r = n-1;
		int lb = height[l];
		int rb = height[r];
		
		while(l<=r) {
			if(lb<=rb) {
				if(height[l]>=lb) {
					lb = height[l];
				}else {
					result+=(lb-height[l]);
				}
				l++;
				
			}else {
				if(height[r]>=rb) {
					rb=height[r];
				}else {
					result+=(rb-height[r]);
				}
				r--;
			}
		}	
		return result;
	}
	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		int result = trap(height);
		
		System.out.println("the total unit of water trapped is:"+result);
	}

}

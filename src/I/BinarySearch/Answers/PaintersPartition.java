package I.BinarySearch.Answers;

public class PaintersPartition {
	
	public static int getPartCount(int[] canvas, int part) {
		int count=1;
		int tot=0;
		for(int i=0;i<canvas.length;i++) {
			if(tot+canvas[i]>part) {
				count++;
				tot=canvas[i];
			}else {
				tot+=canvas[i];
			}
		}
		
		
		return count;
	}
	public static int getMaxCanvas(int[] canvas,int k) {
		int low =0;
		int high = 0;
		for(int i=0;i<canvas.length;i++) {
			low = Math.max(low,canvas[i]);
			high+=canvas[i];
		}
		while(low<=high) {
			int mid = (low+high)/2;
			int count = getPartCount(canvas,mid);
			if(count>k) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}			
			
		return low;		
	}
	public static void main(String[] args) {
		int[] canvas = {10, 20, 30, 40};
		int k = 2;
		int max = getMaxCanvas(canvas,k);
		System.out.println("The max size of canvas in the partition is:"+ max);
	}
}

package I.BinarySearch.Answers;

public class AllocateMinPages {
	
	public static int getCount(int[] pages,int num) {
		int count=1;
		int pgCount=pages[0];
		for(int i=1;i<pages.length;i++) {
			if(pages[i]+pgCount>num) {
				count++;
				pgCount = pages[i];
			}else {
				pgCount+=pages[i];
			}
		}
		
		
		return count;
	}

	public static int getMaxAllocation(int[] pages,int m) {
        if (m > pages.length)
            return -1;
		int low = 0;
		int high = 0;
		for(int i=0;i<pages.length;i++) {
			low=Math.max(low, pages[i]);
			high+=pages[i];
		}
		
		while(low<=high) {
			int mid = (low+high)/2;
			int count = getCount(pages,mid);
			if(count<=m) {
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		
		return low;
	}
	public static void main(String[] args) {
		int[] pages = {25, 46, 28, 49, 24};
		int m =4;
		int max = getMaxAllocation(pages,m);
		
		System.out.println("The maximum number of pages allocation to the student is:"+max);
		
	}
}

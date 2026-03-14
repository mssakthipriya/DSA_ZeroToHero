package H.Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement1By3 {

	public static List<Integer> majorityElements(int[] arr){
		List<Integer> maj = new ArrayList<>();
		int cnt1 = 0;
		int cnt2 = 0;
		int el1 = -1;
		int el2 = -1;
		
		for(int i=0;i<arr.length;i++) {
			if(cnt1==0 && arr[i]!=el2) {
				el1=arr[i];
				cnt1++;
			}else if(cnt2==0 && arr[i]!=el1) {
				el2 = arr[i];
				cnt2++;
			}else if(el1==arr[i]) {
				cnt1++;
			}else if(el2==arr[i]) { 
				cnt2++;
			}else {
				cnt1--;
				cnt2--;
			}
		}
		
		cnt1=0; cnt2=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==el1) cnt1++;
			if(arr[i]==el2) cnt2++;
		}
		int minVal = (int)(arr.length/3)+1;
		
		if(cnt1>=minVal) maj.add(el1);
		if(cnt2>=minVal) maj.add(el2);
		

		return maj;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,2,3,2};
		
		List<Integer> elems = majorityElements(arr);
		System.out.println(elems.toString());
		
		
		
	}
}

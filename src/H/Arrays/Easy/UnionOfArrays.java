package H.Arrays.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionOfArrays {
	
	public static int[] getUnion(int[] arr1,int[] arr2) {
	Set<Integer> union = new HashSet<>();
	int len1 = arr1.length;
	int len2 = arr2.length;
	int j = 0;
	int k = 0;

	while(j<len1 && k<len2){
		if(arr1[j]<arr2[k]) {
			union.add(arr1[j]);
			j++;
		}else {
			union.add(arr2[k]);
			k++;
		}

	}
	int newLength = union.size();
	int[] unionArr = new int[newLength];
	int i=0;
	for(int e : union) {
		unionArr[i] = e;
		i++;
	}
	
	return unionArr;
	
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
		int[] arr2 = {2,3,4,4,5,11,12};
		int[] unionArr = getUnion(arr1,arr2);
		System.out.println(Arrays.toString(unionArr));
	}

}

package L.RecursionPattern;

public class AllPermutations {
	public static void swap(char[] arr,int x,int y) {
		char temp= arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	public static void printAllPermutations(char[] s,int index) {
		if(index==s.length-1) {
			System.out.println(s);
			return;
		}
		
		for(int i=index;i<s.length;i++) {
			swap(s,index,i);
			printAllPermutations(s, index+1);
			swap(s,index,i);
		}
	}
	public static void main(String[] args) {
		String s = "abc";
		printAllPermutations(s.toCharArray(),0);
	}

}

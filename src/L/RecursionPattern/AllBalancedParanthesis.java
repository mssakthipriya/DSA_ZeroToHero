package L.RecursionPattern;

public class AllBalancedParanthesis {
	public static void printAllBalParanthese(char[] arr,int n,int i,int o,int c) {
		if(i==arr.length) {
			System.out.println(arr);
		}
		if(o<n) {
			arr[i]='(';
			printAllBalParanthese(arr,n,i+1,o+1,c);
		}
		if(c<o) {
			arr[i]=')';
			printAllBalParanthese(arr,n,i+1,o,c+1);
		}
	}
	public static void main(String[] args) {
		int n=3;
		char[] arr = new char[n*2];
		printAllBalParanthese(arr,n,0,0,0);
	}

}

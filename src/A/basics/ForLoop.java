package A.basics;

public class ForLoop {

	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			System.out.println(i);
		}
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(j);
			}
		}
		
		int arr[] = new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=i*i;
		}
		
		for (int i : arr) {
			System.out.println(i);
		}
	}
}

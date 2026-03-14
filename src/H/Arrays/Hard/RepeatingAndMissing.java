package H.Arrays.Hard;

public class RepeatingAndMissing {
	
	public static void findRepeatingMissing(int[] arr){
        int n= arr.length;
        int sum=n*(n+1)/2;
        int sum1=0;
        int sumsq=n*(n+1)*((2*n)+1)/6;
        int sumsq1=0;
        for(int i=0;i< arr.length;i++){
            sum1=sum1+arr[i];
            sumsq1=sumsq1+(arr[i]*arr[i]);
        }
        int aminusb=sum-sum1;
        System.out.println("sum1:"+sum+",sum2:"+sum1+",sum1sqr:"+sumsq+",sum2sqr:"+sumsq1);
        int aSqminusbSq=sumsq-sumsq1;
        int aplusb=aSqminusbSq/aminusb;
        int a=(aplusb+aminusb)/2;
        int b=aplusb-a;
        System.out.println("Number : "+a+" "+b);
    }

	
	public static int[] getRepeatMissNum(int[] arr) {
		int[] ans = new int[2];
		int n = arr.length;
		int sum1= n*(n+1)/2;
		int sum1sqr = n*(n+1)*((2*n)+1)/6;
		int sum2=0;
		int sum2sqr = 0;
		for(int i=0;i<arr.length;i++) {
			sum2+=arr[i];
			sum2sqr+=(arr[i]*arr[i]);
		}
        System.out.println("sum1:"+sum1+",sum2:"+sum2+",sum1sqr:"+sum1sqr+",sum2sqr:"+sum2sqr);
		int diff = sum1-sum2;
		System.out.println(diff);
		int sum = (sum1sqr-sum2sqr)/diff;
		ans[1] = (sum+diff)/2;
		ans[0] = sum-ans[1];
		
		return ans;
	}

	public static void main(String[] args) {
		//int[] arr = {3,1,2,5,3};
		int[] arr = {3,1,2,5,4,6,7,5};
		int[] rm = getRepeatMissNum(arr);
		findRepeatingMissing(arr);
		
		System.out.println("The repeating number is :"+rm[0]+", and the missing number is:"+rm[1]);
	}
}

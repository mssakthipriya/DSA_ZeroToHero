package M.AdvancedMaths;

public class PowerXN {

	public static double getPower(double x, int n) {
		double pow = 1;
		int m=n;
		n = Math.abs(n);
		while(n>0) {
			if(n%2==1) {
				pow=pow*x;
				n=n-1;
			}else {
				x=x*x;
				n=n/2;
			}
		}
		
		if(m<0)
			pow = 1/pow;
		
		return pow;
	}
	public static void main(String[] args) {
		double x = 2.0000;
		int n = 10;
		
		double pow = getPower(x,n);
		
		System.out.println(pow);
	}
}

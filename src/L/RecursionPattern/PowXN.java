package L.RecursionPattern;

public class PowXN {

	public static double getPowerII(double x, int n) {
		if(n==0) {
			return 1;
		}
		System.out.println(n);
		if(n%2==0)
			return getPowerII(x*x,n/2);
		else
			return x*getPowerII(x*x,(n-1)/2);
	}

	public static double getPower(double x,double prod, int n) {
		if(n==0) {
			return prod;
		}
		return getPower(x,prod*x,n-1);
	}
	public static void main(String[] args) {
		double x = 2.0;
		int n = 2;
		
		double power = getPower(x,1,n);
		System.out.println(x+" raised to power "+n+" is:"+power);		
		double powerII = getPowerII(x,n);
		System.out.println(x+" raised to power "+n+" is:"+powerII);	
	}
}

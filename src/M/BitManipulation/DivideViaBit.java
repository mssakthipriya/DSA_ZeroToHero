package M.BitManipulation;

public class DivideViaBit {
	public static int getQuotientOpt(int divident, int divisor) {
		if(divident==divisor) return 1;
		boolean sign = true;
		if(divident>=0 && divisor<0) sign = false;
		else if(divident<=0 && divisor > 0) sign = false;
		
		divident = Math.abs(divident);
		divisor = Math.abs(divisor);
		
		int ans =0;
		
		while(divident>=divisor) {
			int q = 0;
			while(divident>(divisor<<(q+1))) {
				q++;
			}
			ans+=(1<<q);
			divident = divident-(divisor<<q);
		}
		if(ans==(1<<31) && sign)
			return Integer.MAX_VALUE;
		
		if(ans==(1<<31) && !sign)
			return Integer.MIN_VALUE;
		
		return sign ? ans: -ans;
	}
	public static int getQuotientBrut(int divident, int divisor) {
		int i=0;
		int val = 0;
		while(divident>=val) {
			val =divisor << i;
			i++;
		}
		return i;
	}
	public static void main(String[] args) {
		int a = 58;
		int b = 5;
		
		
		int quotient = getQuotientOpt(a, b);
		System.out.println(a+"/"+b+"="+quotient);
	}
}

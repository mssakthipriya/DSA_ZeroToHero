package L.RecursionPattern;

public class CountGoodNumbers {
	static int MOD = 1000000007;
	public static long getPowerII(long x,long n) {
		if(n==0) {
			return 1;
		}
			
		if(n%2==0) {
			return getPowerII((x*x)%MOD,n/2)%MOD;
		}else {
			return x*getPowerII((x*x)%MOD,(n-1)/2)%MOD;
		}

	}
    public static long getPower(long x, long n) {
        if (n == 0) {
            return 1;
        }

        long half = getPower(x, n/2);
        long result = (half * half) % MOD;

        if (n % 2 == 1) {
            result = (result * x) % MOD;
        }

        return result;
    }
	
	public static int getGoodNumberCount(int n) {
		return (int)(getPower(4, n/2)*getPower(5,(n+1)/2)%MOD);
	}
	public static void main(String[] args) {
		int n = 50;
		
		int count =getGoodNumberCount(n);
		System.out.println("The number of good numbers are:"+ count);
	}
}

package M.BitManipulation;

public class SetBit {
	
	public static int setBit(int n, int i) {
		int onMask = 1<<i;
		return onMask|n;
	}
	public static int resetBit(int n, int i) {
		int offMask = ~(1<<i);
		return offMask&n;
	}
	
	public static int toggleBit(int n, int i) {
		int toggleMask = 1<<i;
		return toggleMask^n;
	}
	public static void main(String[] args) {
		int n=36;
		int i=5;
		
		int set = setBit(n,i);
		System.out.println(set);
		int notset = resetBit(n,i);
		System.out.println(notset);
		int toggle = toggleBit(n,i);
		System.out.println(toggle);
	}

}

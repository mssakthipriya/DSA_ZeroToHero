package L.RecursionPattern.Combos;

public class TowerOfHanoi {
	
	public static void getMoves(int n, char src, char aux, char dest) {
		if(n==1) {
			//System.out.println("src:"+src+",aux:"+aux+",dest:"+dest);
			System.out.println(src+"->"+dest);		
			return;
		}
		getMoves(n-1, src, dest, aux);
		getMoves(1, src, aux, dest);
		getMoves(n-1, aux, src, dest);
	}
	
	public static void main(String[] args) {
		int n = 3;
		getMoves(n,'A','B','C');
	}

}

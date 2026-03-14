package Q.GreedyAlgorithms;

public class LemonadeChange {
	public static boolean checkLemonadeChange(int[] bills) {
		int five=0;
		int ten = 0;
		for(int i=0;i<bills.length;i++) {
			if(bills[i]==5) {
				five++;
			}else if(bills[i]==10) {
				if(five>0) {
					five--;
					ten++;
				}else {
					return false;
				}
			}else {
				if(five>2 ||(ten>0&&five>0)) {
					if(ten>0) {
						ten--;
						five--;
					}else {
						five=five-3;
					}
				}else {
					return false;
				}
			}
		}
		
		
		return true;
	}
	public static void main(String[] args) {
		int[] bills= {5, 5, 10, 10, 20};
		
		boolean check=checkLemonadeChange(bills);
		
		System.out.println(check);
	}

}

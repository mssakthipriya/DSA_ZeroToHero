package A.basics;

public class WhileLoop {
	
	
public static void main(String[] args) {
	
	int count =0;
	
	while(count<10) {
		System.out.print(count);
		count++;
	}
	System.out.println();
	count = 0;
	
	do {
		System.out.print(count);
		count++;
	} while (count<10);
}
}

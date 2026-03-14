package E.BasicRecursion;

public class NamePrinter {
	
	public static void printName(int n, String name) {
		int count=0;
		if(count==n)
			return;
		System.out.println("Hi, "+name+"!");
		count++;
		printName(n-1,name);
	}
	
	public static void main(String[] args) {
		printName(5, "Sakthi");
	}

}

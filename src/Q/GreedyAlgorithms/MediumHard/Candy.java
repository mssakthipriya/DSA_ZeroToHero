package Q.GreedyAlgorithms.MediumHard;

public class Candy {
    public static int candyCount(int[] ratings) {
        int n = ratings.length;
        int sum = n;
        int i = 1;
        
        while(i<n) {
        	if(ratings[i]==ratings[i-1]) {
        		i++;
        		continue;
        	}
        	int peak = 0;
        	
        	while(i<n && ratings[i]>ratings[i-1]) {
        		peak = peak+1;
        		sum+= peak;
        		i++;
        	}
        	int down = 0;
        	while(i<n && ratings[i]<ratings[i-1]) {
        		down+=1;
        		sum+=down;
        		i++;
        	}
        	
        	if(down>peak) {
        		sum -= Math.min(peak, down);
        	}
        }
        
        
        return sum;
    }
	
	public static void main(String[] args) {
		
		int[] ratings = {1, 2, 2};
		
		int minCandy = candyCount(ratings);
		
		System.out.println(minCandy);
	}

}

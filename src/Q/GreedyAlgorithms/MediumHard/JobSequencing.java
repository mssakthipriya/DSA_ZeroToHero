package Q.GreedyAlgorithms.MediumHard;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {
	public static int[] jobScheduling(int[][] jobs) {
		int n = jobs.length;
		int[] result = new int[2];
		Arrays.sort(jobs, Comparator.comparingInt((int[] a)->a[2]).reversed());
		int maxDeadline = 0;
		for(int i=0;i<n;i++) {
			maxDeadline = Math.max(maxDeadline, jobs[i][1]);
		}
		
		int[] hash = new int[maxDeadline+1];
		Arrays.fill(hash, -1);
		int maxProfit = 0;
		int count = 0;
		for(int i=0;i<n;i++) {
			for(int j = jobs[i][1];j>0;j--) {
				if(hash[j]==-1) {
					hash[j]= jobs[i][0];
					maxProfit +=jobs[i][2];
					count++;
					break;
				}
			}
		}

		result[0] = maxProfit;
		result[1] = count;
		return result;
	}
	public static void main(String[] args) {
		int[][] Jobs = {{1, 2, 100}, {2, 1, 19}, {3, 2, 27}, {4, 1, 25}, {5, 1, 15}} ;
		
		int[] result = jobScheduling(Jobs);
		
		System.out.println("Maximum profit :"+ result[0]);
		System.out.println("Maximum jobs done :"+result[1]);
	}

}

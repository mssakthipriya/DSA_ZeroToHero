package Q.GreedyAlgorithms.MediumHard;

import java.util.Arrays;

public class ShortestJobFirst {
	public static float calculateAverageWaitTime(int[] jobs) {
		int n = jobs.length;
		Arrays.sort(jobs);
		
		int totalTime = 0;
		int waitingTime = 0;
		
		for(int i=0;i<n;i++) {
			waitingTime+=totalTime;
			totalTime+=jobs[i];
		}
		
		return waitingTime/n;
	}
	public static void main(String[] args) {
		int[] jobs = {3, 1, 4, 2, 5};
		
		float avgTime = calculateAverageWaitTime(jobs);
		
		System.out.println(avgTime);
	}
}

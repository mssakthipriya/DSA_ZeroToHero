package O.SlidingWindowTwoPointer.Medium;

public class MaximumCardPoints {

	public static int getMaxCardPoints(int[] cardPoints,int k) {
		int n = cardPoints.length;
		int maxPoints = 0;
		int points = 0;
		int l = 0;
		int r = n-1;
		for(int i=0;i<k;i++) {
			points+=cardPoints[i];
			maxPoints = points;
		}
		for(int i=r;i>n-k;i--) {
			points-=cardPoints[l];
			points+=cardPoints[i];
			maxPoints = Math.max(maxPoints, points);
			l++;
		}
		
		return maxPoints;
	}
	public static void main(String[] args) {
		int[] cardPoints = {1,2,3,4,5,6,1};
		int k =3;
		System.out.println(getMaxCardPoints(cardPoints,k));
	}
}

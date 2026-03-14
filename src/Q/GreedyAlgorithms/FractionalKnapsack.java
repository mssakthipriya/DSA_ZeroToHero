package Q.GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

class Item{
	int value;
	int weight;
	public Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
}
class ItemComparator implements Comparator<Item>{

	@Override
	public int compare(Item a, Item b) {
		double r1 = (double)a.value/(double)a.weight;
		double r2 = (double)b.value/(double)b.weight;
		if(r1<r2) return 1;
		else if(r1>r2) return -1;
		return 0;
	}
	
}
public class FractionalKnapsack {
	public static double getFractionalKnapsack(Item[] arr,int W) {
		int currWeight = 0;
		int sum = 0;
		Arrays.sort(arr, new ItemComparator());
		for(int i=0;i<arr.length;i++) {
			if(currWeight+arr[i].weight<=W) {
				currWeight+=arr[i].weight;
				sum += arr[i].value;
			}else {
				int reminder = W-currWeight;
				sum+=((double)arr[i].value/(double)arr[i].weight)*reminder;
				break;
			}
		}
		
		return sum;
	}
	public static double getMaxWeight(int[] values,int[] weight,int W) {
		int n = values.length;
		Item[] arr = new Item[n];
		for(int i=0;i<n;i++) {
			arr[i]=new Item(values[i],weight[i]);
		}
		return getFractionalKnapsack(arr,W);
	}
	public static void main(String[] args) {
		int W = 50;
		int[] values = {100,60,120};
		int[] weight = {20,10,30};
		
		double maxWeight = getMaxWeight(values,weight,W);
		
		System.out.println(maxWeight);
	}

}

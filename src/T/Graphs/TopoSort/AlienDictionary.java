package T.Graphs.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

	public static List<Integer> topoSort(int k, List<List<Integer>> adj){
		List<Integer> ans = new ArrayList<>();
		
		int[] indegree = new int[k];
		
		for(int i=0;i<k;i++) {
			for(int it : adj.get(i)) {
				indegree[it]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<k;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node  =  q.poll();
			ans.add(node);
			for(int neighbour : adj.get(node)) {
				indegree[neighbour]--;
				if(indegree[neighbour]==0) {
					q.add(neighbour);
				}
			}
			
		}
		
		return ans;
	}
	public static String getAlienOrder(int k, String [] dict) {
		String ans = "";
		List<List<Integer>> adj = new ArrayList<>();
		
		for(int i=0;i<k;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i=0;i<dict.length-1;i++) {
			String str1 = dict[i];
			String str2 = dict[i+1];
			
			int len = Math.min(str1.length(), str2.length());
			
			for(int j=0;j<len;j++) {
				if(str1.charAt(j)!=str2.charAt(j)) {
					adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
					break;
				}
			}
		}
		
		List<Integer> order = topoSort(k,adj);
		
		for(int i=0;i<order.size();i++) {
			ans+=(char)(order.get(i)+'a');
		}		
		
		return ans;
	}
	public static void main(String[] args) {
		String[] dict = {"baa","abcd","abca","cab","cad"};
		int k = 4;
		String ans = getAlienOrder(k,dict);
		
		System.out.println(ans);
	}

}

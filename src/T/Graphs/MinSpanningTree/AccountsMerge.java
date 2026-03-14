package T.Graphs.MinSpanningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
    	int accListSize = accounts.size();
    	DisjointSet dj = new DisjointSet(accListSize);
    	Map<String,Integer> emailGroup = new HashMap<>();
    	for(int i=0;i<accListSize;i++) {
    		int accSize = accounts.get(i).size();
    		for(int j=1;j<accSize;j++) {
    			String email = accounts.get(i).get(j);
    			if(!emailGroup.containsKey(email)) {
    				emailGroup.put(email, i);
    			}else {
    				dj.unionbySize(i, emailGroup.get(email));
    			}
    		}
    	}
    	
    	Map<Integer,List<String>> mergedList = new HashMap<>();
    	
    	for(String email : emailGroup.keySet()) {
    		int group = emailGroup.get(email);
    		int parentGrp = dj.findUParent(group);
    		
    		if(!mergedList.containsKey(parentGrp)) {
    			mergedList.put(parentGrp, new ArrayList<>());
    		}
    		
    		mergedList.get(parentGrp).add(email);
    	}
    	
    	
        List<List<String>> ans = new ArrayList<>();
        for(int group : mergedList.keySet()) {
        	List<String> component = mergedList.get(group);
        	Collections.sort(component);
        	component.add(0, accounts.get(group).get(0));
        	ans.add(component);
        }
        
        
        return ans;
    }
	public static void main(String[] args) {
		String[][] accounts = {{"John","johnsmith@mail.com","john_newyork@mail.com"},
				 			   {"John","johnsmith@mail.com","john00@mail.com"},
				 			   {"Mary","mary@mail.com"},
				 			   {"John","johnnybravo@mail.com"}};
		
		List<List<String>> accList = new ArrayList<>();

        for (String[] account : accounts) {
        	accList.add(Arrays.asList(account));
        }
		
		List<List<String>> mergedAccounts = accountsMerge(accList);
		
        for (List<String> acc : mergedAccounts) {
        	System.out.println(acc);
        }
		}

}

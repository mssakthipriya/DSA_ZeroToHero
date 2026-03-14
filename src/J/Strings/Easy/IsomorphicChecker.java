package J.Strings.Easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicChecker {
    public static boolean isIsomorphic(String s, String t) {
    	Map<Character,Character> map = new HashMap<>();
        int sLen = s.length();
        int tLen = t.length();
        if(sLen!=tLen) {
        	return false;
        }
        
        for(int i=0;i<sLen;i++) {
        	if(map.containsKey(s.charAt(i))) {
        		if(map.get(s.charAt(i))!=t.charAt(i))
        			return false;
        	}else {
        		map.put(s.charAt(i), t.charAt(i));
        	}
        }
        
    	return true;
    }
    
    public static void main(String[] args) {
		String s = "paper";
		String t = "title";
		boolean flag = isIsomorphic(s,t);
		if(flag) {
			System.out.println("The strings "+s+" and "+t+" are isomorphic");
		}else {
			System.out.println("The strings "+s+" and "+t+" are not isomorphic");
		}
	}

}

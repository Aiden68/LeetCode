/*思路：
**设置两个指针i,j
**1.如果相等或模式串（String p)与源串（String s）相等或p为'?',都向前一位
**2.如果p为'*'则j++,找与*后一位匹配的s
**刚开始的思路是DFS递归，不出意外的超时了，
**换双指针思路AC
**有时间试一下把递归改成堆栈试试
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, star = -1, ss = 0;
		while(i < s.length()){
	    	if(j < p.length() && p.charAt(j) == '*'){
				while(++j < p.length() && p.charAt(j) == '*');
				if(j == p.length()){
				    return true;
				}
				star = j - 1;
				while(i < s.length() && j < p.length()){
					if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j) ){
						ss = i;
						break;
					}
					i++;
				}
			}
			else if(j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')){
				i++;
				j++;
			}
			else {
				if(star != -1 && ss < s.length()){
					j = star;
					i = ss + 1;
				}
				else{
					return false;
				}
			}
		}
		while(j < p.length() && p.charAt(j) == '*'){
		    j++;
		};
		return j == p.length();
    }
	
	/*
**丑陋的DFS版本
*/
public boolean isMatchDFS(String s, String p) {
        if(s.equals("")){
            for(int i = 0; i < p.length(); i++){
                if(p.charAt(i) != '*'){
                    return false;
                }
                if(i == p.length() - 1){
                    return true;
                }
            }    
        }
	    return isMatch1(s, p, 0, 0);
	}
	
	public boolean isMatch1(String s, String p, int i, int j) {
		char ts, tp;
	    while(i < s.length() && j < p.length()){
	    	if(p.charAt(j) == '*'){
	    		while(++j < p.length() && p.charAt(j) == '*');
	    		if(j == p.length()){
	    		    return true;
	    		}
	    		while(i < s.length() && j < p.length()){
	    			tp = p.charAt(j);
	    			ts = s.charAt(i);
	    			if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j) ){
	    				if(isMatch1(s, p, i + 1, j + 1)){
	    					return true;
	    				}
	    			}
	    			i++;
	    		}
	    		continue;
	    	}
	    	else if(p.charAt(j) != s.charAt(i) && p.charAt(j) != '?'){
	    		return false;
	    	}
	    	i++;
	    	j++;
	    }
	    while(j < p.length() && p.charAt(j) == '*'){
	        j++;
	    };
	    if(i == s.length() && j == p.length()){
	    	return true;
	    }
	    else{
	    	return false;
	    }
	 }
}

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
		int size = strs[0].length();
		String lcp = "";
		for(int i = 1; i < strs.length; i++){
			int j = 0;
			while(j < size && j < strs[i].length()){
				if(strs[0].charAt(j) != strs[i].charAt(j)){
					break;
				}
				j++;
			}
			size = j;
		}
		for(int i = 0; i < size; i++){
			lcp += strs[0].charAt(i);
		}
		return lcp;
    }
}
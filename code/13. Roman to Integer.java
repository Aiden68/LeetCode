public class Solution {
    public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int res = 0;
        char[] romanNumber = {'I', 'V', 'X','L','C','D','M'};
        int[] num = {1, 5, 10, 50, 100, 500, 1000};
        for(int i = 0; i < romanNumber.length; i++){
        	map.put(romanNumber[i], num[i]);
        }
        for(int i = 0; i < s.length(); i++){
        	int j = i;
            for(; j < s.length() - 1; j++){
                if(map.get(s.charAt(j)) >= map.get(s.charAt(j + 1))){
                	break;
                }
            }
            for(; i < j; i++){
            	res -= map.get(s.charAt(i));
            }
            res += map.get(s.charAt(j));
        }
        return res;
    }
}
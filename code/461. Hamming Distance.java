public class Solution {
    public int hammingDistance(int x, int y) {
		int cnt = 0;
		String temp = Integer.toBinaryString(x ^ y);
		for(int i = 0; i < temp.length(); i++)
		{
			if(temp.charAt(i) == '1'){
				cnt++;
			}
		}
		return cnt;    
	}
}
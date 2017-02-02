public int lengthOfLongestSubstring(String s) {
		int maxlen = 0;
        for (int i = 0; i < s.length() - maxlen; i++) {
			boolean flag[] = new boolean[255];
			int length = 0;
			for (int j = i; j < s.length(); j++) {
				int temp = s.charAt(j);
				if(flag[temp] == true){
					break;
				}
				else{
					flag[temp] = true;
				}
				length++;
				if(maxlen < length){
					maxlen = length;
				}
			}
		}
		return maxlen;
    }
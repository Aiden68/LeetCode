public int minSubArrayLen(int s, int[] nums) {
		int sum = 0;
		int j = 0;
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++){
			while(sum < s && j < nums.length){
				sum += nums[j];
				j++;
			}
			if(j <= nums.length && sum >= s){
				ans = Math.min(ans, j - i);
			}
			else if(j >= nums.length && sum < s){
				break;
			}
			sum -= nums[i];
		}
		if(ans == Integer.MAX_VALUE){
			ans = 0;
		}
		return ans;
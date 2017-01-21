//有点鱼
public int[] twoSum(int[] nums, int target) {
		for(int i = 0; i < nums.length; i++){
			for(int j = i + 1; j < nums.length; j++){
				if(nums[i] + nums[j] == target){
					int[] ans = {i, j};
					return ans;
				}
			}
		} 
		return null;
	}
	
//map
public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(target - nums[i])){
				int[] ans = {map.get(target - nums[i]), i};
				return ans;
			}
			map.put(nums[i], i);
		} 
		return null;
	}
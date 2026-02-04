class Solution {
    private int subarraysWithKDistinctLessThanK(int[] nums, int k) {
        int[] count = new int[nums.length+1];
        int left = 0, res = 0, unique = 0;
        for(int right = 0; right < nums.length; right++){
            if(count[nums[right]] == 0) unique++;
            count[nums[right]]++;
            while(unique > k){
                count[nums[left]]--;
                if(count[nums[left]] == 0) unique--;
                left++;
            }
            res += right-left+1;
        }
        return res;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithKDistinctLessThanK(nums, k) - subarraysWithKDistinctLessThanK(nums, k-1);
    }
}
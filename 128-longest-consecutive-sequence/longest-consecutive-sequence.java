class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int cnt=1;
        int maxLength=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) continue;
            if(nums[i]==nums[i+1]-1){
                cnt++;
            }else {
                cnt=1;
            }
            maxLength=Math.max(maxLength,cnt);
        }
        return maxLength;
    }
}
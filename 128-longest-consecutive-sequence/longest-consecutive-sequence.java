class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int lastSmaller=Integer.MIN_VALUE;
        int cnt=0;
        int maxLength=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1==lastSmaller){
                cnt++;
                lastSmaller=nums[i];
            }else if(nums[i]!=lastSmaller){
                cnt=1;
                lastSmaller=nums[i];
            }
            maxLength=Math.max(maxLength,cnt);
        }
        return maxLength;
    }
}
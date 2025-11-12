class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int prev1=0;
        int prev2=0;
        for(int num=0;num<nums.length-1;num++){
            int temp=prev1;
            prev1=Math.max(prev1,prev2+nums[num]);
            prev2=temp;
        }
        int prev3=0;
        int prev4=0;
        for(int num=1;num<nums.length;num++){
            int temp=prev3;
            prev3=Math.max(prev3,prev4+nums[num]);
            prev4=temp;
        }
        return Math.max(prev1,prev3);
    }
}
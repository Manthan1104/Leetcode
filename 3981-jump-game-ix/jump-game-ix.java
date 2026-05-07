class Solution {
    int[] preMax;
    int[] ans;
    
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        preMax = new int[n];
        int sufMin = nums[n-1];
        preMax[0] = nums[0];

        for(int i=1;i<n;i++){
            preMax[i] = Math.max(preMax[i-1],nums[i]);
        }
        ans = preMax.clone();
        
        for(int i=n-2;i>=0;i--){
            
            if(preMax[i]>sufMin){
                ans[i] = Math.max(ans[i],ans[i+1]);
            }
            sufMin = Math.min(sufMin,nums[i]);
        }

        return ans;

    }
}
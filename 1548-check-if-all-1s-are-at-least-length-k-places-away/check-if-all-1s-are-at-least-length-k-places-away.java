class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(count!=-1 && i-count-1<k){
                    return false;
                }
                count=i;
            }
        }
        return true;
    }
}
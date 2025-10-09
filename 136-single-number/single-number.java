class Solution {
    public int singleNumber(int[] nums) {
        int XORR=0;
        for(int i=0;i<nums.length;i++){
            XORR=XORR^nums[i];
        }
        return XORR;
    }
}
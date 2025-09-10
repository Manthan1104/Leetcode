class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=0;
        int mn=(n*(n+1))/2;
        for(int m:nums){
            sum+=m;
        }
        return mn-sum;
    }

}
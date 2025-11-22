class Solution {
    public int minimumOperations(int[] nums) {
        int cnt=0;
        for(int num:nums){
            int rem=num%3;
            if(rem==1) cnt+=1;
            else if(rem==2) cnt+=1;
        }
        return cnt;
    }
}
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count=0;
        boolean foound1=false; 
        for(int i : nums){
            if(i==1){
                if(count<k && foound1){
                    return false;
                }
                else{
                    count=0;
                    foound1=true;
                }
            }
            else{
                count++;
            }
        }
        return true;
    }
}
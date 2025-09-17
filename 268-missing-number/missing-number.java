class Solution {
    public int missingNumber(int[] nums) {
       int XOR1 =0,XOR2=0;
        int n=nums.length-1;
        for(int i=0;i<=n;i++){
            XOR2=XOR2^nums[i];
            XOR1=XOR1^(i+1);
        }
        //XOR1=XOR1^N;
        return XOR1^XOR2;
    }

}
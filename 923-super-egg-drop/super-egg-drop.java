class Solution {
    public int superEggDrop(int k, int n) {
        int[] dp = new int[k+1];
        int move = 0;

        while(dp[k] < n){
            move++;
            for(int i = k; i >= 1; i--){
                dp[i] = dp[i] + dp[i-1] + 1;
            }
        }
        return move;
    }
}
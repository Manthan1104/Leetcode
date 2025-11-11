class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int t=cost.length;
        int prev2=cost[0];
        int prev1=cost[1];

        for(int i=2;i<t;i++){
            int min=cost[i]+Math.min(prev2,prev1);
            prev2=prev1;
            prev1=min;
        }
        return Math.min(prev2,prev1);
    }
}
class Solution {
    public int climbStairs(int n) {
        if(n<=1)return 1;
        int a=1, b=1;
        int c=0;
        for (int i = 2; i <= n; i++) {
            c=a+b;
            b=a;
            a=c;
        }
        return a;   
    }
}
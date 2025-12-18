class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        //total means the total profit without changing;
        //then we change k so we create k profit in the window of k
        long total = 0L;
        long sum = 0L;
        for(int i = 0;i<k/2;i++){
            total += prices[i]*strategy[i];
            //first half become 0 so 
            sum -= prices[i]*strategy[i];
        }
        //second half part become 1;
        for(int i = k/2;i<k;i++){
            total += prices[i]*strategy[i];
            sum += prices[i]*(1-strategy[i]);
        }
        long max = Math.max(sum, 0);
        for(int i = k;i<prices.length;i++){
            //three points to be changed
            total += prices[i]*strategy[i];
            //newi count in profit
            sum += prices[i]*(1-strategy[i]);//5-(-5)
            //i-k/2 change from 1 to 0 
            sum -= prices[i-k/2];//5*1-5*0;
            //the most left goes out of window i-k when we calculate it is 0 
            //so it depends on it is profit 0 to 0 or 1 or -1
            sum += prices[i-k]*strategy[i-k];

            max = Math.max(max, sum);
        }
        return total + max;
    }
}
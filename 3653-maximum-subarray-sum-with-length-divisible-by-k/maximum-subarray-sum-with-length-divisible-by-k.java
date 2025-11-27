class Solution {
    public long maxSubarraySum(int[] nums, int k) {
       long[] minPref = new long[k];
        Arrays.fill(minPref, Long.MAX_VALUE);

        long prefix = 0;
        minPref[0] = 0;
        
        long ans = Long.MIN_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            prefix += nums[i - 1];
            int rem = i % k;

            if (minPref[rem] != Long.MAX_VALUE) {
                ans = Math.max(ans, prefix - minPref[rem]);
            }
            minPref[rem] = Math.min(minPref[rem], prefix);
        }
        return ans;
    }
}
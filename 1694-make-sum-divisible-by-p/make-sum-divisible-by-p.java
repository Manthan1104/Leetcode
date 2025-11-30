import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) total += num;

        int rem = (int)(total % p);
        if (rem == 0) return 0;  // already divisible

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // prefix before the array starts

        long prefix = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int cur = (int) prefix;

            // we need a previous prefix remainder "need"
            int need = (cur - rem + p) % p;

            // if we saw this remainder earlier, we found a valid subarray
            if (map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }

            // update map with latest index for this remainder
            map.put(cur, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}

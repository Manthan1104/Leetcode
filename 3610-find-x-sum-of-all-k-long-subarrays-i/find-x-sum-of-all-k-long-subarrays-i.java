import java.util.*;

public class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            HashMap<Integer, Integer> freq = new HashMap<>();

            // Build frequency map for current window
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // PriorityQueue sorted by frequency desc, then number desc
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                if (freq.get(a).equals(freq.get(b)))
                    return b - a;
                return freq.get(b) - freq.get(a);
            });

            pq.addAll(freq.keySet());

            int count = x;
            int sum = 0;

            // Add top x elements based on freq and value
            while (!pq.isEmpty() && count-- > 0) {
                int num = pq.poll();
                sum += num * freq.get(num);
            }

            res[i] = sum;
        }

        return res;
    }

    // You can test using a main method
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 4, x = 2;
        System.out.println(Arrays.toString(s.findXSum(nums, k, x))); 
        // Expected output example: [13, 17, 15]
    }
}

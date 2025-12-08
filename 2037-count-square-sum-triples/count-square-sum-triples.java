class Solution {
    public int countTriples(int n) {

        // Step 1: Precompute squares of all numbers from 1 to n
        int[] square = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            square[i] = i * i;
        }

        int count = 0;

        // Step 2: Check all pairs (a, b)
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {

                int sum = square[a] + square[b];

                // Step 3: Check if sum is a perfect square
                int c = (int) Math.sqrt(sum);

                // Step 4: Validate c
                if (c <= n && square[c] == sum) {
                    count++;
                }
            }
        }

        return count;
    }
}

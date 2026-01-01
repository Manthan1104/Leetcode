class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // start from last index
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;     // add 1
                return digits;   // done
            }
            digits[i] = 0;       // carry forward
        }

        // if all digits were 9 (e.g. 999 → 1000)
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}

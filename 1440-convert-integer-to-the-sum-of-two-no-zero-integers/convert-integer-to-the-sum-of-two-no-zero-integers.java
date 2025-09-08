class Solution {
        public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int j = n - i;
            if (noZero(i) && noZero(j)) {
                return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    private boolean noZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) return false;
            num /= 10;
        }
        return true;
    }
}

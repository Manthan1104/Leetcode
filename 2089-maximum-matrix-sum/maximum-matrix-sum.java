class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int neg = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = matrix[i][j];
                if (v < 0) neg++;
                long a = Math.abs((long) v);
                sum += a;
                if (a < min) min = a;
            }
        }
        if ((neg & 1) == 1) sum -= 2 * min;
        return sum;
    }
}
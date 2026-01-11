class Solution {
    private int getLargestAreaInAHistogram(int[] arr, Stack<Integer> st) {
        st.clear();

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {

            while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int value = arr[st.pop()];
                int pse = st.isEmpty() ? -1 : st.peek();
                max = Math.max(max, (i - pse - 1) * value);
            }

            st.push(i);
        }

        while(!st.isEmpty()) {
            int value = arr[st.pop()];
            int pse = st.isEmpty() ? -1 : st.peek();
            max = Math.max(max, (arr.length - pse - 1) * value);
        }

        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        int maxRectangle = Integer.MIN_VALUE;

        int m = matrix.length;
        int n = matrix[0].length;

        Stack<Integer> st = new Stack<>();

        int[] arr = new int[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0') {
                    arr[j] = 0;
                } else {
                    arr[j] += 1;
                }
            }
            
            maxRectangle = Math.max(maxRectangle, getLargestAreaInAHistogram(arr, st));
        }

        return maxRectangle;
    }
}
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        int count = 0;
        for(int i = 0; i < apple.length; i++) {
            sum += apple[i];
        }
        Arrays.sort(capacity);
        int j = capacity.length - 1;
        while(j >= 0) {
            sum -= capacity[j];
            count++;
            if(sum <= 0) break;
            j--;
        }
        return count;
    }
}
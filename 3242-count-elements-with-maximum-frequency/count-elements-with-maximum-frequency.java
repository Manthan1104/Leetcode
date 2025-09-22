import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0;
        for (int freq : freqMap.values()) {
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }
        int sum = 0;
        for (int freq : freqMap.values()) {
            if (freq == maxFreq) {
                sum += freq;
            }
        }

        return sum;
    }
}
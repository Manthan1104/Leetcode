import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int right = 0, left = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            if (charMap.containsKey(currentChar)) {
                left = Math.max(charMap.get(currentChar) + 1, left);
            }
            charMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
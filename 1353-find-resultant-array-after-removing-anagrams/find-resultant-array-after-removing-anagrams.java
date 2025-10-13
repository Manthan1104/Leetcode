import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = result.get(result.size() - 1);

            char[] a1 = prev.toCharArray();
            char[] a2 = words[i].toCharArray();
            Arrays.sort(a1);
            Arrays.sort(a2);

            if (!Arrays.equals(a1, a2)) {
                result.add(words[i]);
            }
        }
        return result;
    }
}

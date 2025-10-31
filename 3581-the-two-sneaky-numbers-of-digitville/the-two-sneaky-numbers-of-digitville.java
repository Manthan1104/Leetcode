import java.util.*;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    // avoid adding the same duplicate multiple times
                    if (!duplicates.contains(nums[i])) {
                        duplicates.add(nums[i]);
                    }
                }
            }
        }

        // Convert list to array
        int[] result = new int[duplicates.size()];
        for (int i = 0; i < duplicates.size(); i++) {
            result[i] = duplicates.get(i);
        }

        return result;
    }
}

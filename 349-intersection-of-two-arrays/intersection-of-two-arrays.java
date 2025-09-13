import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       // ArrayList<Integer> resultList = new ArrayList<>();
        Set<Integer> resultSet = new HashSet<>();
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0;

        // Ensure arrays are sorted for two-pointer method
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                resultSet.add(nums1[i]);
                i++;
                j++;
            }
        }

        // Convert ArrayList → int[]
        int[] result = new int[resultSet.size()];
        int k = 0;
        for (int num : resultSet) {
            result[k++] = num;
        }

        return result;
    }
}

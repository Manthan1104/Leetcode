class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            HashSet<Integer> hashSet = new HashSet<>();

            for (int j = i + 1; j < n; j++) {

                int third = -(nums[i] + nums[j]);

                if (hashSet.contains(third)) {

                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    st.add(temp);
                }

                hashSet.add(nums[j]);
            }
        }

        return new ArrayList<>(st);
    }
}
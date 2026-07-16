class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        helper(nums, vis, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int[] nums, boolean[] vis,List<Integer> ds,List<List<Integer>> ans) {

        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!vis[i]) {

                vis[i] = true;
                ds.add(nums[i]);

                helper(nums, vis, ds, ans);

                ds.remove(ds.size() - 1);
                vis[i] = false;
            }
        }
    }
}
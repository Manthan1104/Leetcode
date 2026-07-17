class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        helper(0, target, candidates, new ArrayList<>(), ans);

        return ans;
    }

    void helper(int index, int target, int[] arr,
                List<Integer> temp,
                List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // Skip duplicates
            if (i > index && arr[i] == arr[i - 1])
                continue;

            // No need to continue (array is sorted)
            if (arr[i] > target)
                break;

            temp.add(arr[i]);

            helper(i + 1, target - arr[i], arr, temp, ans);

            temp.remove(temp.size() - 1);
        }
    }
}
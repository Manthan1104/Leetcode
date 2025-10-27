class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            int value=mpp.getOrDefault(nums[i],0);
            mpp.put(nums[i],value+1);
        }
        //searching for the majority element:
        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 3)) {
                result.add(it.getKey());
            }
        }

        return result;
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int prefsum=0,cnt=0;
        for(int i=0;i<n;i++){
            prefsum+=nums[i];
            int remove=prefsum-k;
            cnt+=map.getOrDefault(remove,0);
            map.put(prefsum,map.getOrDefault(prefsum,0)+1);
        }
        return cnt;
    }
}
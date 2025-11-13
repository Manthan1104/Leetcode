// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int n=nums.length;
//         if(n ==0)return 0;
//         int longest=1;

//         Set<Integer> set=new HashSet<>();
//         for(int i=0;i<n;i++){
//             set.add(nums[i]);
//         }

//         for(int it:set){
//             if(!set.contains(it-1)){
//                 int cnt=1;
//                 int x=it;
//                 while(set.contains(x+1)){
//                     x++;
//                     cnt++;

//                 }
//                 longest=Math.max(longest,cnt);
//             }
//         }
//         return longest;

//     }
// }


class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int lastSmaller=Integer.MIN_VALUE;
        int cnt=0;
        int maxLength=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1==lastSmaller){
                cnt++;
                lastSmaller=nums[i];
            }else if(nums[i]!=lastSmaller){
                cnt=1;
                lastSmaller=nums[i];
            }
            maxLength=Math.max(maxLength,cnt);
        }
        return maxLength;
    }
}
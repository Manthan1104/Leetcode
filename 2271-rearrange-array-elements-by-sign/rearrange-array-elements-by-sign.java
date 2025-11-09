//Brute

// class Solution {
//     public int[] rearrangeArray(int[] nums) {
//         int n=nums.length;
//         ArrayList<Integer>pos=new ArrayList<>();
//         ArrayList<Integer>neg=new ArrayList<>();

//         for(int i=0;i<n;i++){
      
//       if(nums[i]>0) pos.add(nums[i]);
//       else neg.add(nums[i]);
//   }

//   for(int i=0;i<n/2;i++){
      
//       nums[2*i] = pos.get(i);
//       nums[2*i+1] = neg.get(i);
//   }

 
//   return nums;
//     }
// }

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                ans[negIndex] = nums[i];
                negIndex += 2;
            } else {
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
        }

        return ans;
    }
}
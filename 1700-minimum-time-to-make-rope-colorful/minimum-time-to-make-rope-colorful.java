class Solution {
    public int minCost(String colors, int[] neededTime) {
        char arr[]=colors.toCharArray();
        int count=0;
        for(int i=1;i<colors.length();i++){
            if(arr[i]==arr[i-1]){
                if(neededTime[i]>neededTime[i-1]){
                    count+=neededTime[i-1];
                }
                else{
                     count+=neededTime[i];
                     neededTime[i]=neededTime[i-1];
                }
            }
        }
        return count;
    }
}
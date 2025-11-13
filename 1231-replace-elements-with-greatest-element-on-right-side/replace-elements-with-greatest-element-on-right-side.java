class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        int maxi=-1;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>maxi){
                int temp=maxi;
                maxi=arr[i];
                arr[i]=temp;
            }
            else
                arr[i]=maxi;
        }
        return arr;
    }
}
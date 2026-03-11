class Solution {
    Integer dp[][]=new Integer[101][10001];
   
    public int superEggDrop(int K, int N) {
      
        if(K==1)
            return N;
        
        if(N==0 || N==1)
            return N;
        
        if(dp[K][N]!=null)
            return dp[K][N];
        
        int i,l=1,h=N;
        int ans=Integer.MAX_VALUE;

        while(l<=h)
        {
            int mid=(l+h)/2;
            
            int down_temp=superEggDrop(K-1,mid-1);
            
            int up_temp=superEggDrop(K,N-mid);
            
            int temp=1+Math.max(down_temp,up_temp);
           
            if(down_temp<up_temp)
                l=mid+1;
            else 
                h=mid-1;
            
            ans=Math.min(temp,ans);
        }
        return dp[K][N]=ans;
    }
}
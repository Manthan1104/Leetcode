class Solution {
    public int reverse(int x) {
        int revNo=0;
        while(x!=0){
            int lastdigit=x%10;
            x=x/10;

            if(revNo>Integer.MAX_VALUE/10 ||(revNo==Integer.MAX_VALUE/10 && lastdigit>7)) return 0;
            if(revNo<Integer.MIN_VALUE/10 ||(revNo==Integer.MIN_VALUE/10 && lastdigit<-8)) return 0;
            revNo= (revNo*10)+lastdigit;
        }
        return revNo;

    }
}
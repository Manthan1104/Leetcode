class Solution {
    public boolean judgeCircle(String moves) {
        int x=0; int y=0;
            for(char ch :moves.toCharArray()){
                if(ch=='L'){
                    x++;
                }
                if(ch=='R'){
                    x--;
                }
                if(ch=='D'){
                    y++;
                }
                if(ch=='U'){
                    y--;
                }
            }

            return x==0&&y==0;
    }
}
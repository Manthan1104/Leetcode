class Solution {
    public boolean doesAliceWin(String s) {
        String vowels="aeiouAEIOU";
        for(int i=0;i<s.length();i++){
            if(vowels.indexOf(s.charAt(i))!=-1){
                return true;
            }
        }
        return false;
    }
}
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        
        for(int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            boolean change = false, valid = true;
            
            for(char ch : s.toCharArray()) {
                if(ch == '3' || ch == '4' || ch == '7') {
                    valid = false;
                    break;
                } 
                else if(ch != '0' && ch != '1' && ch != '8') {
                    change = true;
                }
            }
            
            if(change && valid) count++;
        }
        
        return count;
    }
}
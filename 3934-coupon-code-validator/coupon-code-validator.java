import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Integer> validIndices = new ArrayList<>();
        
        // Filter valid coupons
        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && getRank(businessLine[i]) != -1 && isValidCode(code[i])) {
                validIndices.add(i);
            }
        }
        
        // Sort based on business priority, then lexicographically by code
        validIndices.sort((a, b) -> {
            int rankA = getRank(businessLine[a]);
            int rankB = getRank(businessLine[b]);
            if (rankA != rankB) {
                return Integer.compare(rankA, rankB);
            }
            return code[a].compareTo(code[b]);
        });
        
        // Extract result
        List<String> result = new ArrayList<>();
        for (int index : validIndices) {
            result.add(code[index]);
        }
        return result;
    }
    
    // Helper to get priority rank. Returns -1 if invalid business.
    private int getRank(String business) {
        switch (business) {
            case "electronics": return 1;
            case "grocery": return 2;
            case "pharmacy": return 3;
            case "restaurant": return 4;
            default: return -1;
        }
    }
    
    // Helper to validate code characters (Alphanumeric or '_')
    private boolean isValidCode(String s) {
        if (s == null || s.isEmpty()) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }
}
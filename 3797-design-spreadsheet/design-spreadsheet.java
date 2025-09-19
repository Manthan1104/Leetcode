import java.util.*;

class Spreadsheet {
    private Map<String, Integer> cells;

    public Spreadsheet(int rows) {
        cells = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) {
        if (formula.charAt(0) == '=') {
            formula = formula.substring(1); // remove '='
        }
        
        int n = formula.length();
        int i = 0, result = 0, sign = 1;
        
        while (i < n) {
            char ch = formula.charAt(i);
            
            if (ch == '+') {
                sign = 1;
                i++;
            } else if (ch == '-') {
                sign = -1;
                i++;
            } else {
                StringBuilder token = new StringBuilder();
                
                // read token (letters + digits OR just digits)
                while (i < n && formula.charAt(i) != '+' && formula.charAt(i) != '-') {
                    token.append(formula.charAt(i));
                    i++;
                }
                
                String t = token.toString();
                int val;
                if (Character.isDigit(t.charAt(0))) {
                    val = Integer.parseInt(t);
                } else {
                    val = cells.getOrDefault(t, 0);
                }
                
                result += sign * val;
            }
        }
        
        return result;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
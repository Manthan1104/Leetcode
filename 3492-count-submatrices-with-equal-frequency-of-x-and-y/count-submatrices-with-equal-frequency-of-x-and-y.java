
import java.util.*;

public class Solution {
    public int[][] calculatePrefixSum(char[][] grid, char targetChar) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] prefixSum = new int[rows][cols];
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                prefixSum[row][col] = (grid[row][col] == targetChar ? 1 : 0);
                if (row > 0) prefixSum[row][col] += prefixSum[row - 1][col];
                if (col > 0) prefixSum[row][col] += prefixSum[row][col - 1];
                if (row > 0 && col > 0) prefixSum[row][col] -= prefixSum[row - 1][col - 1];
            }
        }
        
        return prefixSum;
    }
    
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] xCountPrefixSum = calculatePrefixSum(grid, 'X');
        int[][] yCountPrefixSum = calculatePrefixSum(grid, 'Y');
        
        int matchingSubmatricesCount = 0;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (xCountPrefixSum[row][col] == yCountPrefixSum[row][col] && xCountPrefixSum[row][col] > 0) {
                    matchingSubmatricesCount++;
                }
            }
        }
        return matchingSubmatricesCount;
    }
}
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from all Pacific border cells (top & left)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);        // left border
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]); // right border
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);        // top border
            dfs(heights, atlantic, m - 1, j, heights[m - 1][j]); // bottom border
        }

        List<List<Integer>> result = new ArrayList<>();

        // Find intersection: cells reachable by both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    // DFS traversal
    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        // Out of bounds or already visited or downhill (invalid)
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || heights[r][c] < prevHeight)
            return;

        visited[r][c] = true;

        // Explore all 4 directions
        dfs(heights, visited, r + 1, c, heights[r][c]); // down
        dfs(heights, visited, r - 1, c, heights[r][c]); // up
        dfs(heights, visited, r, c + 1, heights[r][c]); // right
        dfs(heights, visited, r, c - 1, heights[r][c]); // left
    }
}

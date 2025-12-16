// class Solution {

//     public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
//         // Build tree
//         List<Integer>[] tree = new List[n];
//         for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
//         for (int[] edge : hierarchy) {
//             tree[edge[0] - 1].add(edge[1] - 1);
//         }

//         int[][][] dp = new int[n][2][budget + 1];  // [node][parentBought][budget]
//         dfs(0, present, future, tree, dp, budget);

//         // Answer is the max profit in dp[0][0][b] for any b <= budget
//         int ans = 0;
//         for (int b = 0; b <= budget; b++) {
//             ans = Math.max(ans, dp[0][0][b]);
//         }
//         return ans;
//     }

//     private void dfs(int u, int[] present, int[] future, List<Integer>[] tree,
//                             int[][][] dp, int budget) {
//         // Base case: no children, init to 0
//         for (int b = 0; b <= budget; b++) dp[u][0][b] = dp[u][1][b] = 0;

//         // For each child, process recursively
//         List<int[][]> childDPs = new ArrayList<>();
//         for (int v : tree[u]) {
//             dfs(v, present, future, tree, dp, budget);
//             childDPs.add(new int[][]{dp[v][0], dp[v][1]});
//         }

//         // For parentNotBought and parentBought
//         for (int parentBought = 0; parentBought <= 1; parentBought++) {
//             int price = parentBought == 1 ? present[u] / 2 : present[u];
//             int profit = future[u] - price;

//             // Create DP array to fill for this u
//             int[] curr = new int[budget + 1];

//             // Option 1: don't buy u
//             int[] base = new int[budget + 1];
//             base[0] = 0;
//             for (int[][] child : childDPs) {
//                 int[] next = new int[budget + 1];
//                 for (int b1 = 0; b1 <= budget; b1++) {
//                     for (int b2 = 0; b1 + b2 <= budget; b2++) {
//                         next[b1 + b2] = Math.max(next[b1 + b2], base[b1] + child[0][b2]);
//                     }
//                 }
//                 base = next;
//             }

//             for (int b = 0; b <= budget; b++) {
//                 curr[b] = Math.max(curr[b], base[b]); // not buying u
//             }

//             // Option 2: buy u
//             if (price <= budget) {
//                 int[] baseBuy = new int[budget + 1];
//                 baseBuy[0] = 0;
//                 for (int[][] child : childDPs) {
//                     int[] next = new int[budget + 1];
//                     for (int b1 = 0; b1 <= budget; b1++) {
//                         for (int b2 = 0; b1 + b2 <= budget; b2++) {
//                             next[b1 + b2] = Math.max(next[b1 + b2], baseBuy[b1] + child[1][b2]);
//                         }
//                     }
//                     baseBuy = next;
//                 }

//                 for (int b = price; b <= budget; b++) {
//                     curr[b] = Math.max(curr[b], baseBuy[b - price] + profit);
//                 }
//             }

//             dp[u][parentBought] = curr;
//         }
//     }
// }




class Solution {
    private ArrayList<Integer>[] adj;
    private int[] present, future;
    private int budget;
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.budget = budget;
        this.present = present;
        this.future = future;
        this.adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<Integer>();
        for(int[] edge : hierarchy) adj[edge[0] - 1].add(edge[1] - 1);
        return dfs(0).skip[budget];
    }
    private Node dfs(int index) {
        int price1 = Math.min(present[index], budget + 1), price2 = Math.min(present[index] / 2, budget + 1);
        int[] take1 = new int[budget + 1], skip = new int[budget + 1], take2 = new int[budget + 1];
        Arrays.fill(take1, 0, price1, Integer.MIN_VALUE);
        Arrays.fill(take2, 0, price2, Integer.MIN_VALUE);
        Arrays.fill(take1, price1, budget + 1, future[index] - price1);
        Arrays.fill(take2, price2, budget + 1, future[index] - price2);

        for(int next : adj[index]) {
            Node node = dfs(next);
            for(int i = budget; i >= price1; i--) {
                int max1 = Integer.MIN_VALUE, max2 = max1;
                for(int j = 0; j <= i; j++) {
                    skip[i] = Math.max(skip[i], skip[i - j] + node.skip[j]);
                    max1 = Math.max(max1, take1[i - j] + node.take[j]);
                    max2 = Math.max(max2, take2[i - j] + node.take[j]);
                }
                take1[i] = max1;
                take2[i] = max2;
            }
            for(int i = price1 - 1; i >= price2; i--) {
                int max = Integer.MIN_VALUE;
                for(int j = 0; j <= i; j++) {
                    skip[i] = Math.max(skip[i], skip[i - j] + node.skip[j]);
                    max = Math.max(max, take2[i - j] + node.take[j]);
                }
                take2[i] = max;
            }
            for(int i = price2 - 1; i >= 0; i--) {
                for(int j = 0; j <= i; j++) skip[i] = Math.max(skip[i], skip[i - j] + node.skip[j]);
            }
        }
        Node current = new Node(budget);
        for(int i = 0; i <= budget; i++) {
            current.skip[i] = Math.max(take1[i], skip[i]);
            current.take[i] = Math.max(take2[i], skip[i]);
        }
        return current;
    }
}
class Node {
    int[] take, skip;
    public Node(int budget) {
        this.take = new int[budget + 1];
        this.skip = new int[budget + 1];
    }
}
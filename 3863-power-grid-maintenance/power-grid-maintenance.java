import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        // Step 1: Create DSU for power grid connections
        DSU dsu = new DSU(c + 1);
        for (int[] edge : connections) {
            dsu.union(edge[0], edge[1]);
        }

        // Step 2: Each connected component → TreeSet of online stations
        Map<Integer, TreeSet<Integer>> compSets = new HashMap<>();

        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            compSets.putIfAbsent(root, new TreeSet<>());
        }

        // Step 3: Initially all stations are online
        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            compSets.get(root).add(i);
        }

        // Step 4: Process queries and store answers
        List<Integer> ansList = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int root = dsu.find(x);

            if (type == 1) {
                // Type 1 → check query
                if (online[x]) {
                    ansList.add(x);
                } else {
                    TreeSet<Integer> set = compSets.get(root);
                    if (set.isEmpty()) ansList.add(-1);
                    else ansList.add(set.first());
                }
            } else if (type == 2) {
                // Type 2 → station goes offline
                if (online[x]) {
                    online[x] = false;
                    compSets.get(root).remove(x);
                }
            }
        }

        // Step 5: Convert List to array
        int[] res = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) res[i] = ansList.get(i);
        return res;
    }

    // ----- DSU Implementation -----
    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }
}

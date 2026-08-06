import java.util.*;

class Solution {

    class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        // Build adjacency list
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new Pair(v, w));
        }

        // Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        // Min Heap
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.time - b.time);

        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int time = current.time;

            // Skip outdated entries
            if (time > dist[node])
                continue;

            for (Pair neighbour : graph.get(node)) {

                int nextNode = neighbour.node;
                int newTime = time + neighbour.time;

                if (newTime < dist[nextNode]) {

                    dist[nextNode] = newTime;

                    pq.offer(new Pair(nextNode, newTime));
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}
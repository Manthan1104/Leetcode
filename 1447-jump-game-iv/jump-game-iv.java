class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], e -> new ArrayList<>()).add(i);
        }
        queue.offer(0);
        visited[0] = true;
        int jump = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int pos = queue.poll();
                if (pos == n-1) return jump;
                if (pos + 1 < n && !visited[pos + 1]) {
                    queue.offer(pos + 1);
                    visited[pos + 1] = true;
                }
                if (pos - 1 >= 0 && !visited[pos - 1]) {
                    queue.offer(pos - 1);
                    visited[pos - 1] = true;
                }
                if (map.containsKey(arr[pos])) {
                    for (int index: map.get(arr[pos])) {
                        if (!visited[index]) {
                            queue.offer(index);
                            visited[index] = true;
                        }
                    }
                    map.remove(arr[pos]);
                }
            }
            jump++;
        }
        return jump;
    }
}
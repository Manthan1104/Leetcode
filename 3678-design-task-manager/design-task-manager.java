import java.util.*;

class TaskManager {
    // Heap entries: [priority, taskId, userId] (we keep userId in heap but will
    // trust taskMap for the current owner)
    private PriorityQueue<int[]> maxHeap;
    // taskId -> [userId, priority]
    private Map<Integer, int[]> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0];   // priority desc
            return b[1] - a[1];                    // taskId desc
        });
        taskMap = new HashMap<>();
        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        maxHeap.offer(new int[]{priority, taskId, userId});
    }

    public void edit(int taskId, int newPriority) {
        if (!taskMap.containsKey(taskId)) return;
        int userId = taskMap.get(taskId)[0];
        taskMap.put(taskId, new int[]{userId, newPriority});
        maxHeap.offer(new int[]{newPriority, taskId, userId});
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId); // lazy deletion
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.peek();
            int priority = top[0];
            int taskId = top[1];

            int[] current = taskMap.get(taskId);
            if (current != null && current[1] == priority) {
                // This heap entry corresponds to the current mapping.
                // Use the authoritative userId from taskMap (not top[2]).
                maxHeap.poll();
                int userId = current[0];
                taskMap.remove(taskId);
                return userId;
            }
            // stale entry (removed/edited) — discard it
            maxHeap.poll();
        }
        return -1;
    }
}


/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
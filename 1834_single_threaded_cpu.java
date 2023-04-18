class Solution {
    // TC: O(nlog(n)): SC: O(n)
    public int[] getOrder(int[][] tasks) {
        int[][] tasksWithId = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            tasksWithId[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(tasksWithId, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        List<Integer> res = new ArrayList<>();
        //System.out.println(Arrays.deepToString(tasksWithId));
        int curId = 0;
        int endTime = tasksWithId[0][0];
        while (curId < tasks.length) {
            if (pq.isEmpty()) {
                endTime = tasksWithId[curId][0];
                pq.offer(tasksWithId[curId++]);
                
            }
            int[] task = pq.poll();
            endTime += task[1];
            //System.out.println(endTime);
            res.add(task[2]);
            while (curId < tasks.length && tasksWithId[curId][0] <= endTime) {
                pq.offer(tasksWithId[curId++]);
            }
            //System.out.println("" + curId + " endTime: " + endTime);
            //System.out.println(pq);
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll()[2]);
        }
        int[] ret = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
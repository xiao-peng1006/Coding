class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] counter = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];

            if (graph.containsKey(src)) {
                graph.get(src).add(dest);
            } else {
                graph.put(src, new ArrayList<>(Arrays.asList(dest)));
            }

            counter[dest]++;
        }

        int[] ans = new int[numCourses];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (counter[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans[count++] = node;
            if (graph.containsKey(node)) {
                for (int i : graph.get(node)) {
                    counter[i]--;
                    if (counter[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }

        return count == numCourses ? ans : new int[]{};
    }
}
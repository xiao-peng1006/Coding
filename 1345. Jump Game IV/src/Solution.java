class Solution {
    public int minJumps(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }


        List<Integer> curs = new LinkedList<>();
        curs.add(0);

        Set<Integer> visited = new HashSet<>();

        int steps = 0;

        while (!curs.isEmpty()) {
            List<Integer> next = new LinkedList<>();

            for (int cur : curs) {

                if (cur == arr.length - 1) {
                    return steps;
                }

                for (int child : graph.get(arr[cur])) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        next.add(child);
                    }
                }

                graph.get(arr[cur]).clear();

                if (cur + 1 < arr.length && !visited.contains(cur + 1)) {
                    next.add(cur + 1);
                    visited.add(cur + 1);
                }

                if (cur - 1 >= 0 && !visited.contains(cur - 1)) {
                    next.add(cur - 1);
                    visited.add(cur - 1);
                }
            }

            curs = next;
            steps++;
        }

        return -1;
    }
}
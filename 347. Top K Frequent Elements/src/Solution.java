class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> map.get(n1) - map.get(n2));

        for (int key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) heap.poll();
        }

        int[] top = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
            top[i++] = heap.poll();
        }
        return top;
    }
}
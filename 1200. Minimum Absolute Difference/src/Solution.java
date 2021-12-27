class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            int calDiff = Math.abs(arr[i] - arr[i+1]);
            if (calDiff < diff) {
                diff = calDiff;
                ans.clear();
                ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i+1])));
            } else if (calDiff == diff) {
                ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i+1])));
            }
        }
        return ans;
    }
}
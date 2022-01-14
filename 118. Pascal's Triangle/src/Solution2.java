class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList(Arrays.asList(1)));

        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                int num = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                list.add(num);
            }
            list.add(1);
            ans.add(list);
        }

        return ans;
    }
}
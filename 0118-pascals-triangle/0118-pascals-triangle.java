class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> line = new ArrayList<Integer>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }

            result.add(line);
        }

        return result;
    }
}
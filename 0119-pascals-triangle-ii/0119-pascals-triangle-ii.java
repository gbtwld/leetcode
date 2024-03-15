class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> line = new ArrayList<Integer>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }

            if (i == rowIndex) {
                return line;
            }

            result.add(line);
        }

        return new ArrayList<Integer>();
    }
}
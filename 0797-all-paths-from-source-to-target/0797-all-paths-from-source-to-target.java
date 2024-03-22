class Solution {
    public List<List<Integer>> result = new ArrayList<>();

    public void dfs(int[][] graph, List<Integer> sub, int curNum) {
        if (curNum == graph.length - 1) {
            sub.add(curNum);
            System.out.println(sub);
            result.add(new ArrayList(sub));
            sub.remove(sub.size() - 1);
            return;
        }

        for (int i = 0; i < graph[curNum].length; i++) {
            sub.add(curNum);
            dfs(graph, sub, graph[curNum][i]);
            sub.remove(sub.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> sub = new ArrayList<Integer>();

        dfs(graph, sub, 0);

        return result;
    }
}
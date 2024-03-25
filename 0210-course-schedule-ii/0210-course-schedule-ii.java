class Solution {
    public boolean visit(int a, boolean[][] arr, int[] visited, List<Integer> result) {
        if (visited[a] == 1)
            return false;
        if (visited[a] == 2) {
            if (!result.contains(a)) {
                result.add(a);
            }
            return true;
        }

        visited[a] = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[a][i] == true) {
                if (!visit(i, arr, visited, result)) {
                    return false;
                }
            }
        }

        if (!result.contains(a)) {
            result.add(a);
        }

        visited[a] = 2;

        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return new int[1];
        }
        int n = prerequisites.length;
        boolean[][] arr = new boolean[numCourses][numCourses];
        int[] visited = new int[numCourses];
        List<Integer> result = new ArrayList<Integer>();
        int[] ans = new int[numCourses];

        for (int i = 0; i < n; i++) {
            arr[prerequisites[i][0]][prerequisites[i][1]] = true;
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visit(i, arr, visited, result)) {
                return new int[0];
            }
        }

        for (int i = 0; i < numCourses; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
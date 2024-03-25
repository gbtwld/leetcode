class Solution {
    public boolean visit(int a, boolean[][] arr, int[] visited) {
        if (visited[a] == 1) return false;
        if (visited[a] == 2) return true;

        visited[a] = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[a][i] == true) {
                if (!visit(i, arr, visited)) {
                    return false;
                }
            }
        }

        visited[a] = 2;

        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        boolean[][] arr = new boolean[numCourses][numCourses];
        int[] visited = new int[numCourses];

        for (int i = 0; i < n; i++) {
            arr[prerequisites[i][0]][prerequisites[i][1]] = true;
        }

        for (int i = 0; i < numCourses; i++) {
            if(!visit(i, arr, visited)) {
                return false;
            }
        }

        return true;
    }
}
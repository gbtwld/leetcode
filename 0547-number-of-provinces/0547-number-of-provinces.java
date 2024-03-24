class Solution {
    public int result = 0;

    public void dfs(int[][] isConnected, int n) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[n][j] == 1) {
                isConnected[n][j] = 0;
                if (j != n) {
                    dfs(isConnected, j);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        for (int i = 0; i < n; i++) {
            if (isConnected[i][i] == 1) {
                result++;
            }
            dfs(isConnected, i);
        }

        return result;
    }
}
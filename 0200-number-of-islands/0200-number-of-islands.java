class Solution {
    public int[] dx = new int[]{-1, 0, 1, 0};
    public int[] dy = new int[]{0, 1, 0, -1};

    public void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        visited[i][j] = true;
        
        for (int dir = 0; dir < 4; dir++) {
            int nx = i + dx[dir], ny = j + dy[dir];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && grid[nx][ny] == '1') {
                    dfs(nx, ny, grid, visited);
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, result = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, visited);
                    result++;
                }
            }
        }
        return result;
    }
}
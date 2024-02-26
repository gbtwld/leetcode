class Solution {
    public int[] dx = new int[] { 0, -1, 0, 1 };
    public int[] dy = new int[] { -1, 0, 1, 0 };

    public void dfs(char[][] board, int i, int j, boolean[][] visited, boolean[][] dp) {
        dp[i][j] = true;
        visited[i][j] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = i + dx[dir], ny = j + dy[dir];

            if (!(nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length) || visited[nx][ny] || board[nx][ny] == 'X') continue;

            dfs(board, nx, ny, visited, dp);
        }
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        char[][] origin = board.clone();
        boolean[][] dp = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)) continue;
                if (board[i][j] == 'X') continue;

                boolean[][] visited = new boolean[m][n];

                dfs(board, i, j, visited, dp);
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!dp[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
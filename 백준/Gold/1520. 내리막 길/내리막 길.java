import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                dp[i][j] = -1;
            }
        }

        dfs(0, 0);
        System.out.println(dp[0][0]);
    }

    private static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                continue;
            }
            if (map[nx][ny] < map[x][y]) {
                dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
}
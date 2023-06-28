import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int t, m, n, k;
    static int[][] ground;
    static boolean[][] visit;

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            if (visit[nx][ny] || ground[nx][ny] == 0) {
                continue;
            }
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        t = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < t; i++) {
            int bug_count = 0;
            stk = new StringTokenizer(br.readLine(), " ");

            m = Integer.parseInt(stk.nextToken());
            n = Integer.parseInt(stk.nextToken());
            k = Integer.parseInt(stk.nextToken());

            ground = new int[m][n];
            visit = new boolean[m][n];
            for (int j = 0; j < k; j++) {
                stk = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());

                ground[x][y] = 1;
            }

            for (int j = 0; j < m; j++) {
                for (int s = 0; s < n; s++) {
                    if (!visit[j][s] && ground[j][s] == 1) {
                        dfs(j, s);
                        bug_count++;
                    }
                }
            }
            System.out.println(bug_count);
        }
    }
}
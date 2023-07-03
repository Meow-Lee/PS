import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] dist;
    static boolean[][] visit;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());

        dist = new int[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];
        bfs(x, y);

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            sb.append(dist[a][b]).append(' ');
        }
        System.out.println(sb.toString());
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 8; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx <= 0 || ny <= 0 || nx > n || ny > n) {
                    continue;
                }
                if (visit[nx][ny]) {
                    continue;
                }
                q.offer(new Pair(nx, ny));
                visit[nx][ny] = true;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }
    }
}
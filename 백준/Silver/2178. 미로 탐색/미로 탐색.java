import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static String[] map;
    static int[][] dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static class Pair{
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new String[n];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }
        bfs(0, 0);

        System.out.println(dist[n - 1][m - 1]);
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        dist[x][y] = 1;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (map[nx].charAt(ny) == '0' || dist[nx][ny] > 0) {
                    continue;
                }
                q.offer(new Pair(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }
    }
}
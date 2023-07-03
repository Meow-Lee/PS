import java.util.*;
import java.io.*;

public class Main {
    static int t, l;
    static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    static int[] dy = {2, 1, -2, -1, -2, -1, 2, 1};
    static int[][] dist;
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        t = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine());

            l = Integer.parseInt(stk.nextToken());

            stk = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());

            stk = new StringTokenizer(br.readLine(), " ");
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            dist = new int[l][l];

            bfs(x1, y1);

            System.out.println(dist[x2][y2]);
        }
    }

    static void bfs(int x1, int y1) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x1, y1));

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                dist[i][j] = -1;
            }
        }
        dist[x1][y1] = 0;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 8; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= l || ny >= l) {
                    continue;
                }
                if (dist[nx][ny] != -1) {
                    continue;
                }
                q.offer(new Pair(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }
    }
}
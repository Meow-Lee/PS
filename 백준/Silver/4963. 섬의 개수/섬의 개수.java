import java.util.*;
import java.io.*;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static StringTokenizer stk;
    static BufferedReader br;

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            stk = new StringTokenizer(br.readLine(), " ");

            w = Integer.parseInt(stk.nextToken());
            h = Integer.parseInt(stk.nextToken());

            // escape
            if (w == 0 && h == 0) {
                break;
            }

            // initialize
            input();

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visit[i][j] && map[i][j] != 0) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void input() throws Exception {
        map = new int[h][w];
        visit = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
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
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    continue;
                }
                if (visit[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                q.offer(new Pair(nx, ny));
                visit[nx][ny] = true;
            }
        }
    }
}
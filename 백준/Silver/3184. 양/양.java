import java.util.*;
import java.io.*;

public class Main {
    static int r, c, sheep, wolf, s_count, w_count;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String[] land;
    static boolean[][] visit;
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

        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        land = new String[r];
        visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            land[i] = br.readLine();
        }

        s_count = 0;
        w_count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visit[i][j] && land[i].charAt(j) != '#') {
                    sheep = 0;
                    wolf = 0;
                    bfs(i, j);
                }
            }
        }
        System.out.print(s_count + " " + w_count);
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        visit[x][y] = true;
        if (land[x].charAt(y) == 'v') {
            wolf++;
        }
        if (land[x].charAt(y) == 'o') {
            sheep++;
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }
                if (visit[nx][ny] || land[nx].charAt(ny) == '#') {
                    continue;
                }
                q.offer(new Pair(nx, ny));
                visit[nx][ny] = true;

                if (land[nx].charAt(ny) == 'v') {
                    wolf++;
                }
                if (land[nx].charAt(ny) == 'o') {
                    sheep++;
                }
            }
        }
        if (sheep <= wolf) {
            w_count += wolf;
        } else {
            s_count += sheep;
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String[] map;
    static boolean[][][] visit;
    static class Pair {
        int x, y, dist;
        boolean crashed;
        Pair(int x, int y, int dist, boolean crashed) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.crashed = crashed;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map = new String[N];
        visit = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }

        int ans = bfs(0, 0);
        System.out.println(ans);
    }

    static int bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y, 1, false));
        visit[x][y][0] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dist;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (map[nx].charAt(ny) == '1') { // 벽을 마주했는데
                    if (!cur.crashed) { // 벽을 부수지 않은 경우
                        q.offer(new Pair(nx, ny, cur.dist + 1,true));
                        visit[nx][ny][1] = true;
                    }
                } else { // 벽이 아닌 경우
                    if (!cur.crashed && !visit[nx][ny][0]) { // 벽을 부수지 않았고 방문하지 않았을 때
                        q.offer(new Pair(nx, ny, cur.dist + 1, false));
                        visit[nx][ny][0] = true;
                    } else if (cur.crashed && !visit[nx][ny][1]) { // 벽을 부순 적이 있고 방문하지 않았을때
                        q.offer(new Pair(nx, ny, cur.dist + 1, true));
                        visit[nx][ny][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}
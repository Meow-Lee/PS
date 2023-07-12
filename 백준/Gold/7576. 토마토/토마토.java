import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] box;
    static int[][] dist;
    static boolean[][] visit;
    static Queue<Point> q;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        box = new int[N][M];
        dist = new int[N][M];
        visit = new boolean[N][M];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(stk.nextToken());
                dist[i][j] = -1;
                if (box[i][j] == 1) {
                    q.offer(new Point(i, j));
                    visit[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (box[nx][ny] == -1 || visit[nx][ny]) {
                    continue;
                }
                q.offer(new Point(nx, ny));
                visit[nx][ny] = true;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }

        int min = Integer.MIN_VALUE;
        if (check()) {
            return -1;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    min = Math.max(min, dist[i][j]);
                }
            }
        }
        return min;
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[i][j] == -1 && box[i][j] != -1) {
                    return true;
                }
            }
        }
        return false;
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, width, count;
    static int[][] board;
    static boolean[][] visit;
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

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        board = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && board[i][j] == 1) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(width);
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visit[x][y] = true;
        int sum = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (board[nx][ny] == 0 || visit[nx][ny]) {
                    continue;
                }
                q.offer(new Point(nx, ny));
                visit[nx][ny] = true;
                sum++;
            }
        }
        width = Math.max(width, sum);
    }
}